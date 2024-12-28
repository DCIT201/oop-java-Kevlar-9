package org.example;


import java.time.LocalDate;

public class RentalTransaction {
    private String transactionId; // Unique transaction ID
    private Customer customer;    // Associated customer
    private Vehicle vehicle;      // Associated vehicle
    private LocalDate rentalDate; // Date of rental start
    private int rentalDays;       // Number of rental days
    private double totalCost;     // Total rental cost
    private boolean isCompleted;  // Transaction status

    // Constructor
    public RentalTransaction(String transactionId, Customer customer, Vehicle vehicle, LocalDate rentalDate, int rentalDays) {
        if (transactionId == null || transactionId.isBlank()) {
            throw new IllegalArgumentException("Transaction ID cannot be null or blank.");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null.");
        }
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle cannot be null.");
        }
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be positive.");
        }

        this.transactionId = transactionId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
        this.isCompleted = false; // Initially set to active

        // Calculate total cost
        this.totalCost = vehicle.calculateRentalCost(rentalDays);

        // Mark vehicle as unavailable
        vehicle.setAvailable(false);
    }

    // Getters and setters
    public String getTransactionId() {
        return transactionId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeTransaction() {
        if (isCompleted) {
            throw new IllegalStateException("Transaction is already completed.");
        }
        isCompleted = true;
        vehicle.setAvailable(true); // Mark vehicle as available for future rentals
    }

    @Override
    public String toString() {
        return "RentalTransaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customer=" + customer +
                ", vehicle=" + vehicle +
                ", rentalDate=" + rentalDate +
                ", rentalDays=" + rentalDays +
                ", totalCost=" + totalCost +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
