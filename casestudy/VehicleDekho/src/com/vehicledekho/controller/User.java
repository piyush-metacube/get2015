package com.vehicledekho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User
 */
//as of now not in requirement

@WebServlet()//urlPatterns = { "/User", "/User/", "/User/Dashboard", "/User/NewUser", "/User/Dashboard/", "/User/NewUser/" })
// , "/Accounts/User/Dashboard", "/Accounts/User/NewUser" })
public class User extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String servletPath = request.getServletPath();
	System.out.println("User>" + servletPath);

	if (servletPath.equals("/User/Dashboard") || servletPath.equals("/User/Dashboard/") || servletPath.equals("/User")
		|| servletPath.equals("/User/")) {
	    request.getRequestDispatcher("/Accounts/User/Dashboard.jsp").forward(request, response);
	} else if (servletPath.equals("/User/Dashboard")) {
	    request.getRequestDispatcher("../Accounts/User/Dashboard.jsp").forward(request, response);
	} else if (servletPath.equals("/User/NewUser")) {
	    request.getRequestDispatcher("../Accounts/User/NewUser.jsp").forward(request, response);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
    }

}
