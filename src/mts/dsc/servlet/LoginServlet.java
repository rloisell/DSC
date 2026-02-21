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

/*
 * LoginServlet.java
 * Ryan Loiselle — Developer / Architect
 * GitHub Copilot — AI pair programmer / code generation
 * February 2026
 *
 * AI-assisted: rewrote doGet with credential-first authentication logic to fix broken
 * session-gate; fixed hardcoded redirect URL; reviewed and directed by Ryan Loiselle.
 */

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
		HttpSession session;
		String url = "";
		String error = "";

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// If credentials are present (form submission), always attempt authentication
		if (username != null && password != null) {
			// Ensure we have a valid session
			HttpSession existing = request.getSession(false);
			if (existing != null) {
				existing.invalidate();
			}
			session = request.getSession(true);

			if (username.equals("")) {
				error = "Please enter a user name.";
				url = "jsp/login.jsp";
			} else if (password.equals("")) {
				error = "Please enter a password.";
				url = "jsp/login.jsp";
			} else {
				User_Auth uA = null;
				try {
					uA = User_AuthDAO.loadUser_AuthByORMID(username);
				} catch (PersistentException e) {
					e.printStackTrace();
				}
				if (uA == null) {
					error = "Invalid username/password combination";
					url = "jsp/login.jsp";
				} else if (!password.equals(uA.getPassword())) {
					error = "Invalid username/password combination";
					url = "jsp/login.jsp";
				} else { // Successful authentication
					Employee emp = new Employee(uA.getUseremp());
					if (session.getAttribute("employee") != null) {
						session.removeAttribute("employee");
					}
					session.setAttribute("employee", emp);
					// Use context-relative redirect so this works on any host/port
					url = request.getContextPath() + "/ActivityServlet";
				}
			}
		} else {
			// No credentials — show login page with a fresh session
			HttpSession existing = request.getSession(false);
			if (existing != null) {
				existing.invalidate();
			}
			session = request.getSession(true);
			session.setAttribute("visited", "true");
			url = "jsp/login.jsp";
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

} // end LoginServlet
