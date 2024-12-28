package org.example;

public class Car extends Vehicle {
    private static final int FREE_MILEAGE_LIMIT = 100; // Free miles per day
    private static final double EXTRA_MILEAGE_RATE = 0.50; // Charge per mile beyond free limit
    private static final double INSURANCE_RATE = 20.00; // Optional daily insurance fee

    private int milesDriven; // Encapsulated field
    private boolean insuranceSelected; // Encapsulated field

    public Car(String vehicleId, String model, double baseRentalRate) {
        super(vehicleId, model, baseRentalRate);
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        if (milesDriven < 0) {
            throw new IllegalArgumentException("Miles driven cannot be negative.");
        }
        this.milesDriven = milesDriven;
    }

    public boolean isInsuranceSelected() {
        return insuranceSelected;
    }

    public void setInsuranceSelected(boolean insuranceSelected) {
        this.insuranceSelected = insuranceSelected;
    }

    @Override
    public double calculateRentalCost(int days) {
        if (days <= 0) throw new IllegalArgumentException("Days must be positive");

        double rentalCost = getBaseRentalRate() * days;

        // Calculate additional mileage charges
        int totalFreeMileage = FREE_MILEAGE_LIMIT * days;
        if (milesDriven > totalFreeMileage) {
            rentalCost += (milesDriven - totalFreeMileage) * EXTRA_MILEAGE_RATE;
        }

        // Add insurance charges if selected
        if (insuranceSelected) {
            rentalCost += INSURANCE_RATE * days;
        }

        return rentalCost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + getModel() + '\'' +
                ", rentalRate=" + getBaseRentalRate() +
                ", milesDriven=" + milesDriven +
                ", insuranceSelected=" + insuranceSelected +
                '}';
    }


}
