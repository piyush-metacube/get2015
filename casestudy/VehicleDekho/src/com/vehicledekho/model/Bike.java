package com.vehicledekho.model;

public class Bike extends Vehicle {
	private boolean selfStart;
	private double helmetPrice;

	public boolean isSelfStart() {
		return selfStart;
	}

	public void setSelfStart(boolean selfStart) {
		this.selfStart = selfStart;
	}

	public double getHelmetPrice() {
		return helmetPrice;
	}

	public void setHelmetPrice(double helmetPrice) {
		this.helmetPrice = helmetPrice;
	}

	@Override
	public double calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + 500;
	}

	@Override
	public String toString() {
		return super.toString() + "Bike [selfStart=" + selfStart
				+ ", helmetPrice=" + helmetPrice + "]";
	}
}
