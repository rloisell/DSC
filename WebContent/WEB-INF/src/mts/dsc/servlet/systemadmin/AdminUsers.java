package mts.dsc.servlet.systemadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.orm.PersistentException;
import mts.dsc.employee.Employee;
import mts.dsc.orm.*;
import java.util.*;

/**
 * Servlet implementation class AdminUsers
 */
public class AdminUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if (session == null){
			// User has no session, return to login
			response.sendRedirect("/LoginServlet");
		}
		else {
			
			// Get most recent Employee data and add to users session
			Employee anEmployee = (Employee) session.getAttribute("employee");
			String actionS = request.getParameter("action");
			if (actionS == null){
				session.removeAttribute("employee");
				anEmployee.refresh();
				session.setAttribute("employee", anEmployee);
				response.sendRedirect("jsp/adminusers.jsp");
			}
			else {
				char action = actionS.charAt(0);
				switch (action) {
					case 'A':
						// NEW USER INPUT
						int empID = Integer.parseInt(request.getParameter("empID"));
						String firstName = request.getParameter("fName");
						String lastName = request.getParameter("lName");
						String email = request.getParameter("email");

						// NCS DATE
						int nyear = Integer.parseInt(request.getParameter("year"));
						int nmonth = Integer.parseInt(request.getParameter("month"));
						int nday = Integer.parseInt(request.getParameter("day"));
						java.util.Date ncsDate = new Date(nyear-nmonth-nday);
						
						// POSISITON AND POSITION START DATE : User_Position
						// TODO - FIGURE OUT HOW TO READ MORE THEN ONE SET OF CALENDAR ATTRIBUTES USING INCLUDE
						int posID = Integer.parseInt(request.getParameter("position"));
						// String posStartDate = request.getParameter("posStartDate");
						// java.util.Date aDate = new Date(pyear+"-"+pmonth+"-"+pday);
						// newUser.setNcsDate(aDate);
						
						// DEPARTMENT AND DEPARTMENT START DATE: Department_User
						// TODO - FIGURE OUT HOW TO READ MORE THEN ONE SET OF CALENDAR ATTRIBUTES USING INCLUDE
						int deptID = Integer.parseInt(request.getParameter("department"));
						// String depStartDate = request.getParameter("depStartDate");
						// java.util.Date aDate = new Date(pyear+"-"+pmonth+"-"+pday);
						// newUser.setNcsDate(aDate);
						
						// LAN ID, PASSWORD AND DSC ROLE
						String lanID = request.getParameter("lanID");
						String password = request.getParameter("pwd");
						int roldID = Integer.parseInt(request.getParameter("role"));
								
						// CREATE OBJECTS
						mts.dsc.orm.user.User newUser = mts.dsc.orm.user.UserDAO.createUser();
						mts.dsc.orm.user_auth.User_Auth newUserAuth = mts.dsc.orm.user_auth.User_AuthDAO.createUser_Auth();
						mts.dsc.orm.user_position.User_Position newUserPos = mts.dsc.orm.user_position.User_PositionDAO.createUser_Position();
						mts.dsc.orm.department_user.Department_User newDeptUser = mts.dsc.orm.department_user.Department_UserDAO.createDepartment_User();
						mts.dsc.orm.user_user.User_User userMgr = mts.dsc.orm.user_user.User_UserDAO.createUser_User();
						
						// POPULATE USER
						newUser.setEmpId(empID);
						newUser.setFirstName(firstName);
						newUser.setLastName(lastName);
						newUser.setEmail(email);
						newUser.setNcsDate(ncsDate);
						newUser.setRoleID(roldID);
						
						// POPULATE USER_AUTH
						newUserAuth.setUserName(lanID);
						newUserAuth.setPassword(password);
						
						try {
							// ASSOCIATE AND SAVE USER AND USER AUTH
							mts.dsc.orm.user.UserDAO.save(newUser);
							newUserAuth.setUseremp(newUser);
							mts.dsc.orm.user_auth.User_AuthDAO.save(newUserAuth);
							
							// USER POSITION
							mts.dsc.orm.position.Position myPosition = mts.dsc.orm.position.PositionDAO.loadPositionByORMID(posID);
							newUserPos.setUseremp(newUser);
							newUserPos.setPositionposition(myPosition);
							newUserPos.setStartDate(ncsDate); // CHANGE TO POS START DATE (EVENTUALLY)
							mts.dsc.orm.user_position.User_PositionDAO.save(newUserPos);
							
							// DEPARTMENT USER
							mts.dsc.orm.department.Department dept = mts.dsc.orm.department.DepartmentDAO.loadDepartmentByORMID(deptID);
							newDeptUser.setUseremp(newUser);
							newDeptUser.setDepartmentdept(dept);
							newDeptUser.setStartDate(ncsDate); // CHANGE TO POS START DATE (EVENTUALLY)
							mts.dsc.orm.department_user.Department_UserDAO.save(newDeptUser);
							
							// USER - MGR
							userMgr.setUseremp(newUser);
							userMgr.setUserempId2(dept.getUseremp());
							userMgr.setStartDate(ncsDate); // CHANGE TO DEP START DATE (EVENTUALLY)
							mts.dsc.orm.user_user.User_UserDAO.save(userMgr);
						} 
						catch (PersistentException e) {
							e.printStackTrace();
						}
						break;
						// END ADD USER CASE
					
					case 'L':
						
						break;
						// END LOAD USER TO EDIT CASE
					
					case 'S':
						
						break;
						// END SAVE USER EDIT CASE
						
					case 'D':
						
						break;
						// END DELETE USER CASE
						
					default:
						
				}
				// ADD BACK TO SESSION AT THE END
				session.removeAttribute("employee");
				anEmployee.refresh();
				session.setAttribute("employee", anEmployee);			
				
				// Forward to Activity jsp page
				response.sendRedirect("jsp/adminusers.jsp");
			} // END ELSE NOT NULL ACTION
		} // END ELSE NOT NULL SESSION
	} // end doPost
} // end servlet
