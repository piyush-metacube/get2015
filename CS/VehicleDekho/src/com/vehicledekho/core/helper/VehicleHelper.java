package com.vehicledekho.core.helper;

import com.vehicledekho.core.Bike;
import com.vehicledekho.core.Car;
import com.vehicledekho.core.Vehicle;

public class VehicleHelper {
	public static Vehicle createVehicle(String vehicleType, String model,
			String make) {
		if (vehicleType.equalsIgnoreCase("car")) {
			return createCar(model, make);
		} else {
			return carBike(model, make);
		}
	}

	private static Vehicle carBike(String model, String make) {
		Bike bike = new Bike();
		bike.setModel(model);
		bike.setMake(make);
		bike.setSelfStart(true);
		bike.setHelmetPrice(500.80);
		bike.setEngineInCC(125);
		bike.setFuelCapacity(40);
		bike.setRoadTax(2400);
		bike.setMileage(60.0);
		bike.setPrice(80000);
		return bike;
	}

	private static Vehicle createCar(String model, String make) {
		Car car = new Car();
		car.setModel(model);
		car.setMake(make);
		car.setIsAcAvailable(true);
		car.setPowerSteering(true);
		car.setAccessoryKits(true);
		car.setEngineInCC(1225);
		car.setFuelCapacity(400);
		car.setRoadTax(5400);
		car.setMileage(17.25);
		car.setPrice(650000);
		return car;
	}

}
