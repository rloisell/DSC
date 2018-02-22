package mts.dsc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mts.dsc.employee.Employee;

import org.orm.PersistentException;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(true);
		Employee e=(Employee)s.getAttribute("employee");
		if(e==null) {response.sendRedirect("/DSC/LoginServlet");}
		else {
			/*e.refresh();*/
			String type=(String)request.getAttribute("type");
			if(type==null) {response.sendRedirect("/DSC/jsp/reports.jsp");}
			else if(type.equals("weekly")) {
			
			}
			else if(type.equals("yearly")) {
				
			}
			else {response.sendRedirect("/DSC/jsp/reports.jsp");}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
