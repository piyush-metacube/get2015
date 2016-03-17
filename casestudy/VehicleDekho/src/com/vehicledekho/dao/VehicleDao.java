package com.vehicledekho.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vehicledekho.model.Car;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

public class VehicleDao {
    public boolean writeCarToDatabase(Vehicle vehicle) {
	PreparedStatement preparedStatement = null;
	java.sql.Connection connection = Connection.getConnection();
	String writeQueryForCar = "insert into VEHICLE (MAKE,MODEL,MANUFACTURER,TYPE,ENGINE_IN_CC,FUEL_CAPACITY,MILEAGE,PRICE,ROAD_TAX,IS_AC_AVAILABLE,POWER_STEERING,ACCESSORY_KIT) values (?,?,?,?,?,?,?,?,?,?,?,?)";
	try {
	    if (vehicle instanceof Car) {
		preparedStatement = connection.prepareStatement(writeQueryForCar);
		addCommonVehicleProperties(vehicle, preparedStatement);
		addCarFeatures(vehicle, preparedStatement);
		preparedStatement.executeUpdate();
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }

    public boolean updateCarToDatabase(Vehicle vehicle) {
	PreparedStatement preparedStatement = null;
	java.sql.Connection connection = Connection.getConnection();

	String writeQueryForCar = "update VEHICLE Set MAKE=?,MODEL=?,MANUFACTURER=?,TYPE=?,ENGINE_IN_CC=?,FUEL_CAPACITY=?,MILEAGE=?,PRICE=?,ROAD_TAX=?,IS_AC_AVAILABLE=?,POWER_STEERING=?,ACCESSORY_KIT=? where MAKE=? AND MODEL=? AND MANUFACTURER=? ";
	try {
	    if (vehicle instanceof Car) {
		preparedStatement = connection.prepareStatement(writeQueryForCar);
		addCommonVehicleProperties(vehicle, preparedStatement);
		addCarFeatures(vehicle, preparedStatement);
		preparedStatement.setString(13, vehicle.getMake());
		preparedStatement.setString(14, vehicle.getModel());
		preparedStatement.setString(15, vehicle.getManufacturer());
		preparedStatement.executeUpdate();
		return true;
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }

    private void addCarFeatures(Vehicle vehicle, PreparedStatement preparedStatement) throws SQLException {
	preparedStatement.setString(10, String.valueOf(((Car) vehicle).isAcAvailable()));
	preparedStatement.setString(11, String.valueOf(((Car) vehicle).isPowerSteeringAvailable()));
	preparedStatement.setString(12, String.valueOf(((Car) vehicle).isAccessoryKitAvailable()));
    }

    private void addCommonVehicleProperties(Vehicle vehicle, PreparedStatement preparedStatement) throws SQLException {
	preparedStatement.setString(1, vehicle.getMake());
	preparedStatement.setString(2, vehicle.getModel());
	preparedStatement.setString(3, vehicle.getManufacturer());
	preparedStatement.setString(4, VehicleType.CAR.name());
	preparedStatement.setInt(5, vehicle.getEngineInCc());
	preparedStatement.setInt(6, vehicle.getFuelCapacity());
	preparedStatement.setDouble(7, vehicle.getMileage());
	preparedStatement.setDouble(8, vehicle.getPrice());
	preparedStatement.setDouble(9, vehicle.getRoadTax());
    }
}
