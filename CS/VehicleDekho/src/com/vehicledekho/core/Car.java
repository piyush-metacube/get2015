package com.vehicledekho.core;

public class Car extends Vehicle {
	private Boolean isAcAvailable;
	private Boolean powerSteering;
	private Boolean accessoryKit;

	public Boolean getIsAcAvailable() {
		return isAcAvailable;
	}

	public void setIsAcAvailable(Boolean isAcAvailable) {
		this.isAcAvailable = isAcAvailable;
	}

	public Boolean getPowerSteering() {
		return powerSteering;
	}

	public void setPowerSteering(Boolean powerSteerin) {
		this.powerSteering = powerSteerin;
	}

	public Boolean getAccessoryKit() {
		return accessoryKit;
	}

	public void setAccessoryKits(Boolean accessoryKit) {
		this.accessoryKit = accessoryKit;
	}

	@Override
	public double calculateOnRoadPrice() {
		return super.calculateOnRoadPrice() + 1000;
	}

	@Override
	public String toString() {
		return super.toString() + "Car [isAcAvailable=" + isAcAvailable
				+ ", powerSteering=" + powerSteering + ", accessoryKit="
				+ accessoryKit + "]";
	}

}
