package com.vehicledekho.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vehicledekho.dao.VehicleDao;
import com.vehicledekho.factories.VehicleFactory;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

/**
 * Servlet implementation class VehicleUpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleServlet() {
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
	boolean isAcAvailable = false;
	boolean powerSteering = false;
	boolean accessoryKit = false;

	String make = request.getParameter("carnametb");
	String model = request.getParameter("carmodeltb");
	String manufacturer = request.getParameter("manufacturertb");
	int engineInCc = Integer.parseInt(request.getParameter("enginecapacitytb"));
	int fuelCapacity = Integer.parseInt(request.getParameter("fuelcapacitytb"));
	double mileage = Double.parseDouble(request.getParameter("mileagetb"));
	double price = Double.parseDouble(request.getParameter("pricetb"));
	double roadTax = Double.parseDouble(request.getParameter("roadtaxtb"));

	try {
	    request.getParameter("isACAvailableCheckBox").toUpperCase();
	    isAcAvailable = true;
	} catch (Exception e) {
	}

	try {
	    request.getParameter("isPowerSteeringAvailableCheckBox").toUpperCase();
	    powerSteering = true;
	} catch (Exception e) {
	}

	try {
	    request.getParameter("isAccessoryKitAvailableCheckBox").toUpperCase();
	    accessoryKit = true;
	} catch (Exception e) {
	}
	Vehicle car = new VehicleFactory().createVehicle(VehicleType.CAR, make, model, manufacturer, engineInCc, fuelCapacity, mileage, price,
		roadTax, isAcAvailable, powerSteering, accessoryKit);

	VehicleDao vehicleDao = new VehicleDao();

	if (vehicleDao.updateCarToDatabase(car)) {
	    response.sendRedirect("Admin");
	}
    }
}
