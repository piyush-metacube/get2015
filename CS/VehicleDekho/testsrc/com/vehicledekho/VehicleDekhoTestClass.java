package com.vehicledekho;

import static org.junit.Assert.*;

import org.hamcrest.core.StringEndsWith;
import org.junit.Test;

import com.vehicledekho.core.Bike;
import com.vehicledekho.core.Car;
import com.vehicledekho.core.Vehicle;
import com.vehicledekho.core.helper.VehicleHelper;

public class VehicleDekhoTestClass {

	@Test
	public void VehicleHelperTestForCarInstance() {
		Vehicle vehicle = VehicleHelper.createVehicle("car", "Sedan", "2008");
		assertEquals(true, vehicle instanceof Car);
	}

	@Test
	public void VehicleHelperTestForBikeInstance() {
		Vehicle vehicle = VehicleHelper.createVehicle("bike", "CafeRacer", "2008");
		assertEquals(true, vehicle instanceof Bike);
	}

	@Test
	public void VehicleDetailPrinterTestForCar() {
		Vehicle vehicle=VehicleHelper.createVehicle("car", "Sedan", "2008");
		String expString="Vehicle [make=2008, model=Sedan, engineInCC=1225, fuelCapacity=400, mileage=17.25, price=650000.0, roadTax=5400.0]Car [isAcAvailable=true, powerSteering=true, accessoryKit=true]";
		assertEquals(expString,vehicle.toString());
	}
	
	@Test
	public void VehicleDetailPrinterTestForBike() {
		Vehicle vehicle=VehicleHelper.createVehicle("bike", "CafeRacer", "2008");
		String expString="Vehicle [make=2008, model=CafeRacer, engineInCC=125, fuelCapacity=40, mileage=60.0, price=80000.0, roadTax=2400.0]Bike [selfStart=true, helmetPrice=500.8]";
		assertEquals(expString,vehicle.toString());
	}
}
