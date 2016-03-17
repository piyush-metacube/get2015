package com.vehicledekho.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misc.LoginStatus;

import com.vehicledekho.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	String username = request.getParameter("usernametb");
	String password = request.getParameter("passwordtb");
	if (username != null && username != null) {
	    LoginDao loginDao = new LoginDao();
	    boolean isUserExitsInDb = loginDao.validateLogin(username, password);
	    if (isUserExitsInDb) {
		// Logger.log(new java.util.Date().toString() + "  Exiting Admin");
		LoginStatus.setLogged(true);
		response.sendRedirect("Admin");
	    } else {
		// Logger.log(new java.util.Date().toString() + "  Admin Does Not Exist -- " + username + " " + password);
		request.setAttribute("LoginError", "Invalid Credentials");
		request.getRequestDispatcher("Accounts/Login.jsp").forward(request, response);
	    }
	}
    }

}
