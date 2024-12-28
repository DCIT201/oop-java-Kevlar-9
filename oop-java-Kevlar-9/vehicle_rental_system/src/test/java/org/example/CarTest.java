package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void testCarRentals() {
        // Example 1: Valid Rental with No Mileage or Insurance
        Car car1 = new Car("C001", "Toyota Corolla", 40);
        car1.setMilesDriven(300); // 100 miles/day included
        car1.setInsuranceSelected(false);
        double expectedCost1 = 40 * 3; // Base rate only
        assertEquals(expectedCost1, car1.calculateRentalCost(3));

        // Example 2: Valid Rental with Excess Mileage and Insurance
        Car car2 = new Car("C002", "Honda Civic", 50);
        car2.setMilesDriven(700); // 500 miles allowed (100/day)
        car2.setInsuranceSelected(true);
        double expectedCost2 = 50 * 5 + (700 - 500) * 0.50 + 20 * 5; // Base + Mileage + Insurance
        assertEquals(expectedCost2, car2.calculateRentalCost(5));

        // Example 3: Zero-Day Rental
        Car car3 = new Car("C003", "Ford Focus", 30);
        car3.setMilesDriven(0);
        car3.setInsuranceSelected(false);
        double expectedCost3 = 0; // No days, no cost
        assertEquals(expectedCost3, car3.calculateRentalCost(0));

        // Example 4: Negative Mileage Throws Exception
        Car car4 = new Car("C004", "Mazda 3", 45);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            car4.setMilesDriven(-100);
        });
        assertEquals("Miles driven cannot be negative.", exception.getMessage());
    }
}