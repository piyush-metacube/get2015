package com.vehicledekho.model;

public class Car extends Vehicle {
    private boolean isAcAvailable;
    private boolean powerSteering;
    private boolean accessoryKit;

    public boolean isAcAvailable() {
	return isAcAvailable;
    }

    public void setIsAcAvailable(boolean isAcAvailable) {
	this.isAcAvailable = isAcAvailable;
    }

    public Boolean isPowerSteeringAvailable() {
	return powerSteering;
    }

    public void setPowerSteering(boolean powerSteerin) {
	this.powerSteering = powerSteerin;
    }

    public Boolean isAccessoryKitAvailable() {
	return accessoryKit;
    }

    public void setAccessoryKits(boolean accessoryKit) {
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
