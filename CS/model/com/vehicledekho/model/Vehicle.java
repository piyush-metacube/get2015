package com.vehicledekho.model;

public class Vehicle {
	private String make;
	private String model;
	private int engineInCc;
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
		return engineInCc;
	}

	public void setEngineInCC(int engineInCC) {
		this.engineInCc = engineInCC;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + engineInCc;
		result = prime * result + fuelCapacity;
		result = prime * result + ((make == null) ? 0 : make.hashCode());
		long temp;
		temp = Double.doubleToLongBits(mileage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(roadTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (engineInCc != other.engineInCc)
			return false;
		if (fuelCapacity != other.fuelCapacity)
			return false;
		if (make == null) {
			if (other.make != null)
				return false;
		} else if (!make.equals(other.make))
			return false;
		if (Double.doubleToLongBits(mileage) != Double
				.doubleToLongBits(other.mileage))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(roadTax) != Double
				.doubleToLongBits(other.roadTax))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vehicle [make=" + make + ", model=" + model + ", engineInCC="
				+ engineInCc + ", fuelCapacity=" + fuelCapacity + ", mileage="
				+ mileage + ", price=" + price + ", roadTax=" + roadTax + "]";
	}

}
