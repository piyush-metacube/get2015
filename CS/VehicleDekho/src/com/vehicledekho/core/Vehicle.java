package com.vehicledekho.core;

public class Vehicle {
	private String make;
	private String model;
	private int engineInCC;
	private int fuelCapacity;
	private double mileage;
	private double price;
	private double roadTax;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getEngineInCC() {
		return engineInCC;
	}

	public void setEngineInCC(int engineInCC) {
		this.engineInCC = engineInCC;
	}

	public int getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(int fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double milage) {
		this.mileage = milage;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRoadTax() {
		return roadTax;
	}

	public void setRoadTax(double roadTax) {
		this.roadTax = roadTax;
	}

	public double calculateOnRoadPrice() {
		return price + roadTax;
	}

	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", engineInCC="
				+ engineInCC + ", fuelCapacity=" + fuelCapacity + ", mileage="
				+ mileage + ", price=" + price + ", roadTax=" + roadTax + "]";
	}

}
