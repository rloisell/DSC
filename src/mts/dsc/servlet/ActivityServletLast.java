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

public class ActivityServletLast extends HttpServlet{

	

	/**

	 * 

	 */

	private static final long serialVersionUID = 1L;

	/**

     * @see HttpServlet#HttpServlet()

     */

    public ActivityServletLast() {

        super();

    }

	

	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	

	HttpSession session = request.getSession(false);

	if (session == null){

		// User has no session, return to login

		response.sendRedirect("/DSC/LoginServlet");

	}

	else {

		

		// Get employee data associated with this session

		Employee anEmployee = (Employee) session.getAttribute("employee");

				

		// Check for which action has been sent from the jsp/activity.jsp page

		// (expense radio, project radio, submit activity, update activity)

		// Perform tasks for each one

		String action = request.getParameter("action");

		if (action == null){

			action = "";

		}

		String error = "";

		

		

		// Set up date property

		String year = request.getParameter("year");

		String month = request.getParameter("month");

		String day = request.getParameter("day");

		if (year != null && month != null && day != null){

			int y = Integer.parseInt(year);

			int m = Integer.parseInt(month);

			int d = Integer.parseInt(day);

			

			

			// TODO anEmployee.setDate(y, m, d);

			

			

		}

		

		

		

	// Selected Project Radio button

		if (action.equals("projectRadio")){



			session.setAttribute("type", "projectRadio");

			response.sendRedirect("jsp/activity.jsp");

		}

		

	// Selected Expense Radio button	

		else if (action.equals("expenseRadio")){

			

			session.setAttribute("type", "expenseRadio");

			response.sendRedirect("jsp/activity.jsp");

		}

		

	// Submitted new activity

		else if (action.equals("Submit")){ 

			String type = request.getParameter("typeGroup");

			if (type == null){

				error = "Must select an activity type";

				session.setAttribute("error", error);

				response.sendRedirect("jsp/activity.jsp");

			}

	

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

				response.sendRedirect("jsp/activity.jsp");

			}

			if (plannedH < 0 || plannedM < 0 || plannedM > 60 || actualH < 0 || actualM < 0 || actualM > 60){

				error = "Durations must be postive. Minutes must be between 0 and 60.";

				session.setAttribute("error", error);

				response.sendRedirect("jsp/activity.jsp");

			}

			

			

			// Standard input checks passed, Add activity to employee

			else {

				

				try {

				// Compute and add appropriate attributes to an activity	

				ActivityContainer anActivity;

					// TODO - compute durations

					Time planned = new Time((plannedH * 60 + plannedM)* 60 * 1000);

					int actual = actualH * 60 + actualM;

				

				// Project Activity is selected	

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

				// Expense Activity is selected

				else {

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

					

					Category cat = CategoryDAO.loadCategoryByORMID(categoryID);

					anActivity.setCategory(cat);

					anActivity.setDescription(description);

					anActivity.setPlannedDuration(planned);  

					anActivity.setActualDuration(actual);

					//TODO anActivity.setCalandardate(value);

					User aUser = UserDAO.loadUserByORMID(anEmployee.getEmpId());

					anActivity.setUseremp(aUser);

					anEmployee.setActivity(anActivity);

					

					

				} catch (PersistentException e) {

					

					e.printStackTrace();

				}

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

	response.sendRedirect("jsp/activity.jsp");

	}



	

	}

	

	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

	

}