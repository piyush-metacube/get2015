package com.vehicledekho.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import misc.LoginStatus;

import com.vehicledekho.facade.Facade;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if (!LoginStatus.isLogged()) {
	    response.sendRedirect("Login");
	} else {
	    String make = request.getParameter("make");
	    String brand = request.getParameter("brand");
	    String model = request.getParameter("model");
	    if (make == null || brand == null || model == null) {
		response.sendRedirect("Search");
	    } else {
		Facade facade = new Facade();
		Vehicle carVehicle = facade.getCarDetails(VehicleType.CAR, make, model, brand);
		request.setAttribute("CarObject", carVehicle);
		request.getRequestDispatcher("Accounts/Admin/EditVehicle.jsp").forward(request, response);
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
