package org.example;

public class Car extends Vehicle {
    private int milesDriven; // Critical information
    private boolean insuranceSelected; // Additional feature

    // Constructor
    public Car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    // Getter for milesDriven
    public int getMilesDriven() {
        return milesDriven;
    }

    // Setter for milesDriven with validation
    public void setMilesDriven(final int milesDriven) {
        if (milesDriven < 0) {
            throw new IllegalArgumentException("Miles driven cannot be negative.");
        }
        this.milesDriven = milesDriven;
    }

    // Getter for insuranceSelected
    public boolean isInsuranceSelected() {
        return insuranceSelected;
    }

    // Setter for insuranceSelected
    public void setInsuranceSelected(final boolean insuranceSelected) {
        this.insuranceSelected = insuranceSelected;
    }

    @Override
    public double calculateRentalCost(final int days) {
        double baseCost = getBaseRentalRate() * days;
        double mileageCharge = milesDriven > days * 100 ? (milesDriven - days * 100) * 0.50 : 0;
        double insuranceCost = insuranceSelected ? 20 * days : 0;
        return baseCost + mileageCharge + insuranceCost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}
