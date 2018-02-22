package mts.dsc.servlet;

import java.io.IOException;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.orm.PersistentException;
// -- Data Access related --
import mts.dsc.employee.*;
import mts.dsc.orm.network_numbers.*;
import mts.dsc.orm.project.*;
import mts.dsc.orm.reason_code.*;
import mts.dsc.activitycontainer.*;
import mts.dsc.orm.activity_codes.*;
import mts.dsc.orm.category.*;
import mts.dsc.orm.cpc_code.*;
import mts.dsc.orm.director_code.*;
import mts.dsc.orm.user.*;
public class ActivityServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityServlet() {
        super();
    }
		
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession(false);
	if (session == null){
		// User has no session, return to login
		response.sendRedirect("/DSC/LoginServlet");
	}
	else {	
		Employee anEmployee = (Employee) session.getAttribute("employee");	
		try {
			anEmployee = new Employee(UserDAO.loadUserByORMID(anEmployee.getEmpId()));
		}
		catch (PersistentException e) {
			session.removeAttribute("error");
			String error = "PersistentException thrown by Employee";
			session.setAttribute("error", error);
			e.printStackTrace();
			
		}
		// Get categories for the initial display of activity.jsp
		try {
			Category[] categories = CategoryDAO.listCategoryByQuery(null,null);
			session.removeAttribute("categories");
			session.setAttribute("categories", categories);
		} catch (PersistentException e) {
			String error = "PersistentException thrown by Categories";
			session.removeAttribute("error");
			session.setAttribute("error", error);
			e.printStackTrace();
		}
		
		//  Handle Dates sent from the calendar
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		// Check if a date button was pressed
		if (month != null && day != null && year != null){
			anEmployee.setDate(year, month, day);
			anEmployee.refresh();
			session.removeAttribute("employee");
			session.setAttribute("employee", anEmployee);
			response.sendRedirect("jsp/activity.jsp");
		}
		
		// A form button was pressed
		else {
			
			String actionS = request.getParameter("action");
			if (actionS == null){
				
				session.removeAttribute("employee");
				anEmployee.refresh();
				session.setAttribute("employee", anEmployee);
				response.sendRedirect("jsp/activity.jsp");
			}
			
			else {
				int action = 0;
				String error = "";
				if (actionS.equals("1") || actionS.equals("2")){
					action = Integer.parseInt(actionS);
				}
				else if (actionS.equals("Submit")){
					action = 3;
				}
				else if (actionS.equals("Update")){
					action = 4;
				}
			
				
				switch (action){
				case 1: 
					if (session.getAttribute("type") != null) session.removeAttribute("type");
					
					try {
						Project[] projects = ProjectDAO.listProjectByQuery(null, null);
						Network_Numbers[] netNums = Network_NumbersDAO.listNetwork_NumbersByQuery(null, null);
						Activity_Codes[] actCodes = Activity_CodesDAO.listActivity_CodesByQuery(null, null);
						session.removeAttribute("projects");
						session.removeAttribute("netNums");
						session.removeAttribute("actCodes");
						session.setAttribute("projects", projects);
						session.setAttribute("netNums", netNums);
						session.setAttribute("actCodes", actCodes);
						session.setAttribute("type", "projectRadio");
					}
					catch (PersistentException e){
						error = "PersistentException thrown by projectRadio";
						if (session.getAttribute("error") == null) session.removeAttribute("error");
						session.setAttribute("error", error);
					}
					
					
					break;
				case 2:
					if (session.getAttribute("type") != null) session.removeAttribute("type"); 
					try {
						Director_Code[] directors = Director_CodeDAO.listDirector_CodeByQuery(null, null);
						Reason_Code[] reasons = Reason_CodeDAO.listReason_CodeByQuery(null,null);
						CPC_Code[] cpcs = CPC_CodeDAO.listCPC_CodeByQuery(null, null);
						session.removeAttribute("directors");
						session.removeAttribute("reasons");
						session.removeAttribute("cpcs");
						session.setAttribute("directors", directors);
						session.setAttribute("reasons", reasons);
						session.setAttribute("cpcs", cpcs);
						session.setAttribute("type", "expenseRadio");
					}
					catch (PersistentException e){
						error = "PersistentException thrown by expenseRadio";
						if (session.getAttribute("error") == null) session.removeAttribute("error");
						session.setAttribute("error", error);
					}
					
					break;
				case 3: // Add activity
					String type = request.getParameter("typeGroup");
					if (type == null){
						error = "Must select an activity type";
						session.removeAttribute("error");
						session.setAttribute("error", error);
						break;
					}
			
					// Get standard form inputs
					int categoryID = Integer.parseInt(request.getParameter("category"));
					String description = request.getParameter("description");
					String plannedHour = request.getParameter("plannedHour");
					String plannedMin = request.getParameter("plannedMin");
					String actualHour = request.getParameter("actualHour");
					String actualMin = request.getParameter("actualMin");
					
					
					// Check for errors in durations -- TODO sanitize inputs
					int plannedH = 0;
					int plannedM = 0;
					int actualH = 0;
					int actualM = 0;
					try {
						plannedH = Integer.parseInt(plannedHour);
						plannedM = Integer.parseInt(plannedMin);
						actualH = Integer.parseInt(actualHour);
						actualM = Integer.parseInt(actualMin);
					}
					catch (NumberFormatException e){
						error = "Planned and Actual Duration must be integers";
						session.setAttribute("error", error);
						break;
					}
					if (plannedH < 0 || plannedM < 0 || plannedM > 60 || actualH < 0 || actualM < 0 || actualM > 60){
						error = "Durations must be postive. Minutes must be between 0 and 60.";
						session.setAttribute("error", error);
						break;
					}
									
					// Standard input checks passed, Add activity to employee
					else {
						
						try {
							// Compute and add appropriate attributes to an activity	
							ActivityContainer anActivity = null;
							
							// Project Activity radio button is selected	
							if (type.equals("2")){
								String project = request.getParameter("project");
								int netNum = Integer.parseInt(request.getParameter("networkNumbers"));
								int actCode = Integer.parseInt(request.getParameter("activityCodes"));
								
								Project	proj = ProjectDAO.loadProjectByORMID(project);
								Network_Numbers net = Network_NumbersDAO.loadNetwork_NumbersByORMID(netNum);
								Activity_Codes act = Activity_CodesDAO.loadActivity_CodesByORMID(actCode);
								
								anActivity = new ActivityContainer(2);
								anActivity.setProject(proj);
								anActivity.setNetwork_Number(net);
								anActivity.setActivity_Code(act);		
							}
							// Expense Activity radio button is selected
							else if (type.equals("1")){
								String director = request.getParameter("directorCode");
								String reason = request.getParameter("reasonCode");
								String cpc = request.getParameter("cpcCode");
								
								Director_Code dir = Director_CodeDAO.loadDirector_CodeByORMID(director);
								Reason_Code rea = Reason_CodeDAO.loadReason_CodeByORMID(reason);
								CPC_Code cpcC = CPC_CodeDAO.loadCPC_CodeByORMID(cpc);
								
								anActivity = new ActivityContainer(1);
								anActivity.setDirector_Code(dir);
								anActivity.setReason_Code(rea);
								anActivity.setCPC_Code(cpcC);
							}	
							else {
								error = "You must select an activity type";
								session.removeAttribute("error");
								session.setAttribute("error", error);
								break;
							}
						
							// TODO - compute durations
							Time planned = new Time((plannedH * 60 + plannedM)* 60 * 1000);
							int actual = actualH * 60 + actualM;	
						
							Category cat = CategoryDAO.loadCategoryByORMID(categoryID);
							anActivity.setCategory(cat);
							anActivity.setDescription(description);
							anActivity.setPlannedDuration(planned);  
							anActivity.setActualDuration(actual);
							anActivity.setCalandardate(anEmployee.getDate());
							User aUser = UserDAO.loadUserByORMID(anEmployee.getEmpId());
							anActivity.setUseremp(aUser);
							anActivity.save();
							anEmployee.setActivity(anActivity);
							session.setAttribute("type", null);
							
						} catch (PersistentException e) {
							session.removeAttribute("error");
							error = "PersistentException thrown by ActivityServlet. Failed at add activity.";
							session.setAttribute("error", error);
							e.printStackTrace();
						}
					}
					break;
				case 4:
					// Validate all data
					// Get data from form
					
					
					// Delete Activities
					//String[] deletes = request.getParameterValues("delete");
					//for (String del : deletes){	
					//}
					
					// Update all activities from form
					break;
				}
			
				// ADD BACK TO SESSION AT THE END
				session.removeAttribute("employee");
				anEmployee.refresh();
				session.setAttribute("employee", anEmployee);
				
				response.sendRedirect("jsp/activity.jsp");
				
			}// End check action else
		}		
	}// End check session else
	}// End doPost

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
