package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("C001", "John Doe");
        Customer customer2 = new Customer("C002", "Jane Smith");

        // Create vehicles
        Car car = new Car("V001", "Toyota Corolla", 50);
        car.setMilesDriven(120);
        car.setInsuranceSelected(true);

        Truck truck = new Truck("V002", "Ford F-150", 150);
        truck.setHeavyLoad(true);

        Motorcycle motorcycle = new Motorcycle("V003", "Yamaha R15", 30);
        motorcycle.setHasValidLicense(true);
        motorcycle.setHelmetRented(true);

        // Print vehicle details
        System.out.println(car);
        System.out.println(truck);
        System.out.println(motorcycle);

        // Create rental transactions
        RentalTransaction transaction1 = new RentalTransaction(
                "T001",
                customer1,
                car,
                LocalDate.now(),
                3
        );

        RentalTransaction transaction2 = new RentalTransaction(
                "T002",
                customer2,
                truck,
                LocalDate.now(),
                5
        );

        // Print transaction details
        System.out.println(transaction1);
        System.out.println(transaction2);

        // Complete a transaction
        transaction1.completeTransaction();
        System.out.println("Transaction 1 completed. Vehicle availability: " + car.isAvailable());

        // Demonstrate polymorphism
        Vehicle vehicle = motorcycle; // Using Vehicle reference for Motorcycle
        System.out.println("Motorcycle rental cost for 2 days: $" + vehicle.calculateRentalCost(2));
    }
}