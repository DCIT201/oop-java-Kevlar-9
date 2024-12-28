package org.example;

public class Truck extends Vehicle {
    private boolean heavyLoad; // Specific rental rule

    // Constructor
    public Truck(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
        if (baseRentalRate <= 0) {
            throw new IllegalArgumentException("Base rental rate must be positive."); // Correct message
        }
    }


    // Getter for heavyLoad
    public boolean isHeavyLoad() {
        return heavyLoad;
    }

    // Setter for heavyLoad with validation
    public void setHeavyLoad(boolean heavyLoad) {
        this.heavyLoad = heavyLoad;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getBaseRentalRate() * days;
        double heavyLoadCharge = heavyLoad ? 100 : 0;
        double deposit = 200; // Fixed deposit
        return baseCost + heavyLoadCharge + deposit;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}