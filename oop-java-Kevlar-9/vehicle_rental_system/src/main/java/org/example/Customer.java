package org.example;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<String> rentalHistory;

    public Customer(String name, String johnDoe) {
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addRental(String vehicleId) {
        rentalHistory.add(vehicleId);
    }

    public List<String> getRentalHistory() {
        return rentalHistory;
    }
}
