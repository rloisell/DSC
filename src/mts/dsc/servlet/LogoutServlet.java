package mts.dsc.servlet;



import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;





/**

 * Servlet implementation class LogoutServlet

 */

public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public LogoutServlet() {

        super();

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null){

			// User has no session anyways, just send to login

			response.sendRedirect("/DSC/LoginServlet");

		}

		else {

			// Invalidate the users session and return to login page

			session.invalidate();

			response.sendRedirect("/DSC/LoginServlet?logout=logout");	

		}

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}



}

