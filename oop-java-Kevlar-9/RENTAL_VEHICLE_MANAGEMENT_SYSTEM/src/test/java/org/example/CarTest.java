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

        // Example 3: Zero-Day Rental (Should throw exception)
        Car car3 = new Car("C003", "Ford Focus", 30);
        car3.setMilesDriven(0);
        car3.setInsuranceSelected(false);

        Exception exception1 = assertThrows(IllegalArgumentException.class, () -> {
            car3.calculateRentalCost(0); // Passing zero days
        });

// Ensure the message matches exactly
        assertEquals("Days must be positive.", exception1.getMessage().trim());


//         Example 4: Negative-Day Rental (Should throw exception)
        Car car4 = new Car("C004", "Mazda 3", 45);
        car4.setMilesDriven(0);
        car4.setInsuranceSelected(false);
        Exception exception2 = assertThrows(IllegalArgumentException.class, () -> {
            car4.calculateRentalCost(-3); // Passing negative days
        });
        assertEquals("Days must be positive.".trim(), exception2.getMessage().trim());
    }
}