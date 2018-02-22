package mts.dsc.servlet;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import mts.dsc.employee.Employee;
import mts.dsc.orm.user.UserDAO;

/**
 * Servlet implementation class UserReportServlet
 */
public class UserReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReportServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s=request.getSession(false);
		if(s==null) {response.sendRedirect("/DSC/LoginServlet");}
		else {
			Employee e=(Employee)s.getAttribute("employee");
			if(e==null) {response.sendRedirect("/DSC/LoginServlet");}
			else {
				try {
					e=new Employee(UserDAO.loadUserByORMID(e.getEmpId()));
				}
				catch (PersistentException e1) {
					e1.printStackTrace();
				}
				e.refresh();
				s.setAttribute("employee", e);
				String year=(String)request.getParameter("year");
				String month=(String)request.getParameter("month");
				String day=(String)request.getParameter("day");
				if(year==null||month==null||day==null) {
					response.sendRedirect("jsp/user-report.jsp");
				}
				else if(day.equals("")) {
					s.removeAttribute("error");
					s.setAttribute("error", "Please set the day of the month");
					response.sendRedirect("jsp/user-report.jsp");
				}
				else if(year.equals("")) {
					s.removeAttribute("error");
					s.setAttribute("error", "Please set the year");
					response.sendRedirect("jsp/user-report.jsp");
				}
				else {
					GregorianCalendar gC=new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
					s.setAttribute("calendar", gC);
					response.sendRedirect("jsp/weekly-report-user.jsp");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
