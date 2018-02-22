package mts.dsc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

import mts.dsc.employee.Employee;
import mts.dsc.orm.project.Project;
import mts.dsc.orm.project.ProjectDAO;

/**
 * Servlet implementation class ProjectServlet
 */
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
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
				e.refresh();
				s.removeAttribute("employee");
				s.setAttribute("employee", e);
				Project[] pA=null;
				try {
					pA=ProjectDAO.listProjectByQuery(null, "projectNo");
				}
				catch (PersistentException e1) {
					s.removeAttribute("error");
					s.setAttribute("error", e1.getMessage());
				}
				s.removeAttribute("project");
				s.setAttribute("project", pA);
				response.sendRedirect("jsp/project.jsp");
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
