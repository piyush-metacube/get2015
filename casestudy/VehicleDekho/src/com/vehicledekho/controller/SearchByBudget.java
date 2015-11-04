package com.vehicledekho.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicledekho.facade.Facade;
import com.vehicledekho.model.Car;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

/**
 * Servlet implementation class SearchByBudget
 */
@WebServlet("/SearchByBudget")
public class SearchByBudget extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchByBudget() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String make = request.getParameter("make");
	String brand = request.getParameter("brand");
	String model = request.getParameter("model");
	if (make == null || brand == null || model == null) {
	    response.sendRedirect("Search");
	} else {
	    Facade facade = new Facade();
	    Vehicle carVehicle = facade.getCarDetails(VehicleType.CAR, make, model, brand);
	    request.setAttribute("CarDetails", carVehicle);

	    request.getRequestDispatcher("Search/Item.jsp").forward(request, response);
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String startRange = request.getParameter("startRangetb");
	String endRange = request.getParameter("endRangetb");
	ArrayList<Car> carVehicle = new Facade().getCarListInBudget(VehicleType.CAR, Integer.parseInt(startRange), Integer.parseInt(endRange));
	System.out.println(carVehicle.size());
	request.setAttribute("CarList", carVehicle);
	request.getRequestDispatcher("Search/ItemList.jsp").forward(request, response);

    }

}
