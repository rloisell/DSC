package mts.dsc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import mts.dsc.employee.*;
import mts.dsc.orm.user.User;
import mts.dsc.orm.project.*;
import mts.dsc.activitycontainer.*;
import mts.dsc.orm.category.*;

public class ActivityServletOrig extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ActivityServletOrig() {
        super();
    }
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession(false);
	if (session == null){
		// User has no session, return to login
		response.encodeRedirectURL("/DSC/LoginServlet");
	}
	else {
		
		// Get employee data associated with this session
		Employee anEmployee = (Employee) session.getAttribute("employee");
				
		// Check for which action has been sent from the activity.jsp page
		// (expense radio, project radio, submit activity, update activity)
		// Perform tasks for each one
		String action = request.getParameter("action");
		String error = "";
		ActivityContainer anActivity = null;
			
	// Selected Project Radio button
		if (action.equals("projectRadio")){
			// Generate List of projects
			//Project[] projects = ProjectDAO.listProjectByQuery(null, null);
			// Initialize project activity container
			anActivity = new ActivityContainer(2);
			//session.setAttribute("activity", projects);
			// Return to jsp
			response.encodeRedirectURL("activity.jsp");
		}
		
	// Selected Expense Radio button	
		else if (action.equals("expenseRadio")){
			// Generate list of expenses
			
			// Initialize expense activity container
			anActivity = new ActivityContainer(1);
			//session.setAttribute("activity", expenses);
			// Return to jsp
			response.encodeRedirectURL("activity.jsp");
		}
		
	// Submitted new activity
		else if (action.equals("Submit") && anActivity != null){ 
			int categoryID = Integer.parseInt(request.getParameter("category"));
			String description = request.getParameter("description");
			String plannedHour = request.getParameter("plannedHour");
			String plannedMin = request.getParameter("plannedMin");
			String actualHour = request.getParameter("actualHour");
			String actualMin = request.getParameter("actualMin");
			
			// Check for errors in durations -- sanitize inputs
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
				response.encodeRedirectURL("activity.jsp");
			}
			if (plannedH < 0 || plannedM < 0 || plannedM > 60 || actualH < 0 || actualM < 0 || actualM > 60){
				error = "Durations must be postive. Minutes must be between 0 and 60.";
				session.setAttribute("error", error);
				response.encodeRedirectURL("activity.jsp");
			}
			
			
			// Input checks passed, add activity to employee
			else {
					//Category cat = CategoryDAO.loadCategoryByORMID(categoryID);
					
					// TODO - compute durations
					//Time planned = 0;
					int actual = 0;
					
					
					//anActivity.setCategory(cat);
					anActivity.setDescription(description);
					//anActivity.setPlannedDuration(planned);  //  ? Duration value types ?
					anActivity.setActualDuration(actual);
					
					anEmployee.setActivity(anActivity);
					
			}	
		}
		
	// Update button pressed
		else if (action.equals("Update")){
			// Validate all data
			// Get data from form
			
			
			// Delete Activities
			String[] deletes = request.getParameterValues("delete");
			for (String del : deletes){
				
				
			}
			
			// Update all activities from form
			
		}
		
	
	
	// ADD BACK TO SESSION AT THE END
	anEmployee.refresh();
	session.setAttribute("employee", anEmployee);
	
	// Forward to Activity jsp page
	response.encodeRedirectURL("activity.jsp");
	}

	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
