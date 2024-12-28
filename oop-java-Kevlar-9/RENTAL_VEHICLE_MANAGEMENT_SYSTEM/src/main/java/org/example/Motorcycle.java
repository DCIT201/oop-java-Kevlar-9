package org.example;

public class Motorcycle extends Vehicle {
    private boolean hasValidLicense; // Critical rule
    private boolean helmetRented;    // Additional feature

    // Constructor
    public Motorcycle(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    // Getter for hasValidLicense
    public boolean isHasValidLicense() {
        return hasValidLicense;
    }

    // Setter for hasValidLicense with validation
    public void setHasValidLicense(boolean hasValidLicense) {
        if (!hasValidLicense) {
            throw new IllegalArgumentException("Customer must have a valid license to rent a motorcycle.");
        }
        this.hasValidLicense = hasValidLicense;
    }

    // Getter for helmetRented
    public boolean isHelmetRented() {
        return helmetRented;
    }

    // Setter for helmetRented
    public void setHelmetRented(boolean helmetRented) {
        this.helmetRented = helmetRented;
    }

    @Override
    public double calculateRentalCost(int days) {
        double baseCost = getBaseRentalRate() * days;
        double helmetCharge = helmetRented ? 10 * days : 0;
        return baseCost + helmetCharge;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable() && hasValidLicense;
    }

    public boolean hasValidLicense() {
        return hasValidLicense;
    }
}
