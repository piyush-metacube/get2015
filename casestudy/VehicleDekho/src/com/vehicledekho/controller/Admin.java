package com.vehicledekho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misc.LoginStatus;

/**
 * Servlet implementation class AdminDashboard
 */
@WebServlet(urlPatterns = { "/Admin", "/Admin/Dashboard", "/Admin/NewVehicle" })
public class Admin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(LoginStatus.isLogged());
	if (!LoginStatus.isLogged()) {
	    response.sendRedirect("Login");
	} else {
	    String servletPath = request.getServletPath();
	    if (servletPath.equals("/Admin/Dashboard") || servletPath.equals("/Admin/Dashboard/") || servletPath.equals("/Admin")
		    || servletPath.equals("/Admin/")) {
		request.getRequestDispatcher("/Accounts/Admin/Dashboard.jsp").forward(request, response);
	    } else if (servletPath.equals("/Admin/NewVehicle") || servletPath.equals("/Admin/NewVehicle/")) {
		request.getRequestDispatcher("../Accounts/Admin/NewVehicle.jsp").forward(request, response);
	    }
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
