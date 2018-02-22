package mts.dsc.servlet.systemadmin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mts.dsc.employee.Employee;

/**
 * Servlet implementation class AdminProjects
 */
public class AdminExpense extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminExpense() {
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
			response.encodeRedirectURL("/LoginServlet");
		}
		else {
			
			// Get most recent Employee data and add to users session
			Employee anEmployee = (Employee) session.getAttribute("employee");
					
			
			
			
					
			// ADD BACK TO SESSION AT THE END
			anEmployee.refresh();
			session.setAttribute("employee", anEmployee);
			
			// Forward to Activity jsp page
			response.sendRedirect("jsp/adminexpense.jsp");
		} // end else
	} // end doPost
} // end servlet
