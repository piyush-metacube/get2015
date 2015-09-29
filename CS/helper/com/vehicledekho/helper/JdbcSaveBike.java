package com.vehicledekho.helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vehicledekho.jdbc.Connection;
import com.vehicledekho.model.Bike;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

public class JdbcSaveBike {
	public static void writeToDatabase(Vehicle vehicle) {
		PreparedStatement preparedStatement = null;
		java.sql.Connection connection = Connection
				.getConnection();
		String writeQueryForBike = "insert into VEHICLE (TYPE,ENGINE_IN_CC,FUEL_CAPACITY,MILEAGE,PRICE,ROAD_TAX,SELF_START,HELMET_PRICE) values (?,?,?,?,?,?,?,?)";
		try {
			// setting up prepared statement
			if (vehicle instanceof Bike) {
				preparedStatement = connection
						.prepareStatement(writeQueryForBike);
				addCommonVehicleProperties(vehicle, preparedStatement);
				addBikeFeatures(vehicle, preparedStatement);
			}
			// executing prepared statement
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void addBikeFeatures(Vehicle vehicle,
			PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setBoolean(7, ((Bike) vehicle).isSelfStart());
		preparedStatement.setDouble(8, ((Bike) vehicle).getHelmetPrice());

	}

	private static void addCommonVehicleProperties(Vehicle vehicle,
			PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, VehicleType.BIKE.name());
		preparedStatement.setInt(2, vehicle.getEngineInCC());
		preparedStatement.setInt(3, vehicle.getFuelCapacity());
		preparedStatement.setDouble(4, vehicle.getMileage());
		preparedStatement.setDouble(5, vehicle.getPrice());
		preparedStatement.setDouble(6, vehicle.getRoadTax());
	}

}
