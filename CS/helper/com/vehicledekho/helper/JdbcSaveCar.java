package com.vehicledekho.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vehicledekho.jdbc.Connection;
import com.vehicledekho.model.Car;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

public class JdbcSaveCar {
	public static void writeToDatabase(Vehicle vehicle) {
		PreparedStatement preparedStatement = null;
		java.sql.Connection connection = (java.sql.Connection) Connection
				.getConnection();
		String writeQueryForCar = "insert into VEHICLE (TYPE,ENGINE_IN_CC,FUEL_CAPACITY,MILEAGE,PRICE,ROAD_TAX,IS_AC_AVAILABLE,POWER_STEERING,ACCESSORY_KIT) values (?,?,?,?,?,?,?,?,?)";
		try {
			// setting up prepared statement
			if (vehicle instanceof Car) {
				preparedStatement = connection
						.prepareStatement(writeQueryForCar);
				addCommonVehicleProperties(vehicle, preparedStatement);
				addCarFeatures(vehicle, preparedStatement);
			}
			// executing prepared statement
			preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addCarFeatures(Vehicle vehicle,
			PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setBoolean(7, ((Car) vehicle).isAcAvailable());
		preparedStatement.setBoolean(8,
				((Car) vehicle).isPowerSteeringAvailable());
		preparedStatement.setBoolean(9,
				((Car) vehicle).isAccessoryKitAvailable());
	}

	private static void addCommonVehicleProperties(Vehicle vehicle,
			PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, VehicleType.CAR.name());
		preparedStatement.setInt(2, vehicle.getEngineInCC());
		preparedStatement.setInt(3, vehicle.getFuelCapacity());
		preparedStatement.setDouble(4, vehicle.getMileage());
		preparedStatement.setDouble(5, vehicle.getPrice());
		preparedStatement.setDouble(6, vehicle.getRoadTax());
	}
}
