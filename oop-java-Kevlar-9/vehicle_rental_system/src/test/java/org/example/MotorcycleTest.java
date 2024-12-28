package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotorcycleTest {

    @Test
    void testMotorcycleRentals() {
        // Example 1: Valid Rental with Helmet
        Motorcycle moto1 = new Motorcycle("M001", "Yamaha", 30);
        moto1.setHasValidLicense(true);
        moto1.setHelmetRented(true);
        double expectedCost1 = 30 * 2 + 10 * 2; // Base + Helmet
        assertEquals(expectedCost1, moto1.calculateRentalCost(2));

        // Example 2: Valid Rental Without Helmet
        Motorcycle moto2 = new Motorcycle("M002", "Suzuki", 25);
        moto2.setHasValidLicense(true);
        moto2.setHelmetRented(false);
        double expectedCost2 = 25 * 3; // Base rate only
        assertEquals(expectedCost2, moto2.calculateRentalCost(3));

        // Example 3: Invalid License Throws Exception
        Motorcycle moto3 = new Motorcycle("M003", "Ducati", 40);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            moto3.setHasValidLicense(false);
        });
        assertEquals("Customer must have a valid license to rent a motorcycle.", exception.getMessage());

        // Example 4: Zero-Day Rental
        Motorcycle moto4 = new Motorcycle("M004", "Kawasaki", 35);
        moto4.setHasValidLicense(true);
        moto4.setHelmetRented(true);
        double expectedCost4 = 0; // No days, no cost
        assertEquals(expectedCost4, moto4.calculateRentalCost(0));
    }
}