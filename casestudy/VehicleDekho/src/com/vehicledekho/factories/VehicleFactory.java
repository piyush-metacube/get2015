package com.vehicledekho.factories;

import com.vehicledekho.model.Car;
import com.vehicledekho.model.Vehicle;
import com.vehicledekho.model.VehicleType;

public class VehicleFactory {
    public Vehicle createVehicle(VehicleType vehicleType, String make, String model, String manufacturer, int engineInCc, int fuelCapacity,
	    double mileage, double price, double roadTax, boolean isAcAvailable, boolean powerSteering, boolean accessoryKit) {
	if (vehicleType == VehicleType.CAR) {
	    Car car = createCar(vehicleType, make, model, manufacturer, engineInCc, fuelCapacity, price, roadTax, isAcAvailable, powerSteering,
		    accessoryKit);
	    return car;
	}
	return null;
    }

    private Car createCar(VehicleType vehicleType, String make, String model, String manufacturer, int engineInCc, int fuelCapacity, double price,
	    double roadTax, boolean isAcAvailable, boolean powerSteering, boolean accessoryKit) {
	Car car = new Car();
	car.setVehicleType(vehicleType.toString());
	car.setModel(model);
	car.setMake(make);
	car.setManufacturer(manufacturer);
	car.setIsAcAvailable(isAcAvailable);
	car.setPowerSteering(powerSteering);
	car.setAccessoryKits(accessoryKit);
	car.setEngineInCc(engineInCc);
	car.setFuelCapacity(fuelCapacity);
	car.setRoadTax(roadTax);
	car.setMileage(17.25);
	car.setPrice(price);
	return car;
    }
}
