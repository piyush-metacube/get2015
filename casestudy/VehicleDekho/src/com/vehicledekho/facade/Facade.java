package com.vehicledekho.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;
import com.vehicledekho.dao.Connection;
import com.vehicledekho.factories.VehicleFactory;
import com.vehicledekho.model.Car;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

public class Facade {
    public ArrayList<String> getBrandsList(VehicleType vehicleType) {
	ArrayList<String> manufacturerList = new ArrayList<String>();
	Statement statement = null;
	if (vehicleType == VehicleType.CAR) {
	    try {
		statement = (Statement) Connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select distinct(Manufacturer) from vehicle");

		while (resultSet.next()) {
		    manufacturerList.add(resultSet.getString("Manufacturer"));
		}

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return manufacturerList;
    }

    public ArrayList<Car> getCarListInBudget(VehicleType vehicleType, int startRange, int endRange) {
	Statement statement = null;
	Car carVehicle = null;
	ArrayList<Car> carList = new ArrayList<Car>();
	if (vehicleType == VehicleType.CAR) {
	    try {
		statement = (Statement) Connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from VEHICLE where PRICE Between " + startRange + " AND " + endRange);
		while (resultSet.next()) {
		    VehicleFactory vehicleFactory = new VehicleFactory();
		    carVehicle = (Car) vehicleFactory.createVehicle(VehicleType.CAR, resultSet.getString("Make"), resultSet.getString("Model"),
			    resultSet.getString("Manufacturer"), Integer.parseInt(resultSet.getString("engine_In_Cc")),
			    Integer.parseInt(resultSet.getString("fuel_Capacity")), Double.parseDouble(resultSet.getString("mileage")),
			    Double.parseDouble(resultSet.getString("price")), Double.parseDouble(resultSet.getString("road_tax")),
			    Boolean.valueOf(resultSet.getString("is_Ac_Available")), Boolean.valueOf(resultSet.getString("power_Steering")),
			    Boolean.valueOf(resultSet.getString("Accessory_Kit")));
		    carList.add(carVehicle);
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return carList;
    }

    public Vehicle getCarDetails(VehicleType vehicleType, String make, String manufacturer) {
	Statement statement = null;
	Vehicle carVehicle = null;
	if (vehicleType == VehicleType.CAR) {
	    try {
		statement = (Statement) Connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from vehicle where Make='" + make + "' AND Manufacturer='" + manufacturer
			+ "'");

		if (resultSet.next()) {
		    VehicleFactory vehicleFactory = new VehicleFactory();
		    carVehicle = vehicleFactory.createVehicle(VehicleType.CAR, resultSet.getString("Make"), resultSet.getString("Model"),
			    resultSet.getString("Manufacturer"), Integer.parseInt(resultSet.getString("engine_In_Cc")),
			    Integer.parseInt(resultSet.getString("fuel_Capacity")), Double.parseDouble(resultSet.getString("mileage")),
			    Double.parseDouble(resultSet.getString("price")), Double.parseDouble(resultSet.getString("road_tax")),
			    Boolean.valueOf(resultSet.getString("is_Ac_Available")), Boolean.valueOf(resultSet.getString("power_Steering")),
			    Boolean.valueOf(resultSet.getString("Accessory_Kit")));
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return carVehicle;
    }

    public Vehicle getCarDetails(VehicleType vehicleType, String make, String model, String manufacturer) {
	Statement statement = null;
	Vehicle carVehicle = null;
	if (vehicleType == VehicleType.CAR) {
	    try {
		statement = (Statement) Connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from vehicle where Make='" + make + "' AND Model='" + model
			+ "' AND Manufacturer='" + manufacturer + "'");

		if (resultSet.next()) {
		    VehicleFactory vehicleFactory = new VehicleFactory();
		    carVehicle = vehicleFactory.createVehicle(VehicleType.CAR, resultSet.getString("Make"), resultSet.getString("Model"),
			    resultSet.getString("Manufacturer"), Integer.parseInt(resultSet.getString("engine_In_Cc")),
			    Integer.parseInt(resultSet.getString("fuel_Capacity")), Double.parseDouble(resultSet.getString("mileage")),
			    Double.parseDouble(resultSet.getString("price")), Double.parseDouble(resultSet.getString("road_tax")),
			    Boolean.valueOf(resultSet.getString("is_Ac_Available")), Boolean.valueOf(resultSet.getString("power_Steering")),
			    Boolean.valueOf(resultSet.getString("Accessory_Kit")));
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return carVehicle;
    }

    public ArrayList<String> getMakeForBrandList(VehicleType vehicleType, String manufacturer) {
	ArrayList<String> makeList = new ArrayList<String>();
	if (vehicleType == VehicleType.CAR) {
	    try {
		PreparedStatement preparedStatement = Connection.getConnection().prepareStatement(
			"select distinct(Make) from vehicles where Manufacturer=?");
		preparedStatement.setString(1, manufacturer);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
		    makeList.add(rs.getNString("Make"));
		}
		rs.next();

	    } catch (Exception e) {
		// TODO: handle exception
	    }
	}
	return makeList;
    }

    public ArrayList<String> getAllMakeList(VehicleType vehicleType) {
	ArrayList<String> makeList = new ArrayList<String>();
	Statement statement = null;
	if (vehicleType == VehicleType.CAR) {
	    try {
		statement = (Statement) Connection.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select distinct(make) from vehicle");

		while (resultSet.next()) {
		    makeList.add(resultSet.getString("Make"));
		}

	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return makeList;
    }
}
