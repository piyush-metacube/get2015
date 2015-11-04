package com.vehicledekho.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicledekho.facade.Facade;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Facade facade = new Facade();
	ArrayList<String> brandArrayList = facade.getBrandsList(VehicleType.CAR);
	ArrayList<String> makeArrayList = facade.getAllMakeList(VehicleType.CAR);
	request.setAttribute("brandList", brandArrayList);
	request.setAttribute("makeList", makeArrayList);
	request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String manufacturer = request.getParameter("brandselector");
	String make = request.getParameter("makeselector");
	Vehicle carVehicle = new Facade().getCarDetails(VehicleType.CAR, make, manufacturer);
	request.setAttribute("CarDetails", carVehicle);
	request.getRequestDispatcher("Search/Item.jsp").forward(request, response);
    }

}
