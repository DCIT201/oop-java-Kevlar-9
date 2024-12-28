package org.example;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public Vehicle findAvailableVehicle(String model) {
        return fleet.stream()
                .filter(vehicle -> vehicle.getModel().equalsIgnoreCase(model) && vehicle.isAvailableForRental())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("No available vehicle of this model"));
    }
}
