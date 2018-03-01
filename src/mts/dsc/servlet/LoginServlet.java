package mts.dsc.servlet;

import mts.dsc.orm.user_auth.*;
import mts.dsc.employee.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.orm.PersistentException;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessionS=request.getSession(false);
		HttpSession session;
		String url = "";
		String error="";
		
		// Has no session with server -- give new session
		if (sessionS == null){
			session = request.getSession(true);
			session.setAttribute("visited", "true");
			url="jsp/login.jsp";
		}
		
		// Has existing session but has not been here before
		else if (sessionS != null && sessionS.getAttribute("visited") == null){
			sessionS.invalidate();
			session = request.getSession(true);
			session.setAttribute("visited", "true");
			url="jsp/login.jsp";
		}
		
		// Has an existing session and has been here before
		// Begin validation
		else { 
			session = sessionS;
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username==null) {
				error="";
				url="jsp/login.jsp";
			}
			else if(password==null) {
				error="";
				url="jsp/login.jsp";
			}
			else if(username.equals("")) {
				error="Please enter a user name.";
				url="jsp/login.jsp";
			}
			else if(password.equals("")) {
				error="Please enter a password.";
				url="jsp/login.jsp";
			}
			else {
				User_Auth uA=null;
				try {
					uA=User_AuthDAO.loadUser_AuthByORMID(username);
				} catch (PersistentException e) {
					e.printStackTrace();
				}
				if(uA==null) {
					error="Invald username/password combination";
					url="jsp/login.jsp";
				}
				else if(!password.equals(uA.getPassword())) {
					error="Invalid username/password combination";
					url="jsp/login.jsp";
				}
				else { // Successful authentication
					Employee emp=new Employee(uA.getUseremp());
					if (session.getAttribute("employee") != null) session.removeAttribute("employee");
					session.setAttribute("employee", emp);
					url="http://localhost:8081/DSC/ActivityServlet";
					session.removeAttribute("visited");
				}
			}
		}
		session.setAttribute("error", error);
		response.sendRedirect(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
