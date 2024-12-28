package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TruckTest {
    @Test
    void testTruckRentals() {
        // Example 1: Valid Rental with Heavy Load
        Truck truck1 = new Truck("T001", "Freightliner", 80);
        truck1.setHeavyLoad(true);
        double expectedCost1 = 80 * 4 + 100 + 200; // Base + Heavy Load + Deposit
        assertEquals(expectedCost1, truck1.calculateRentalCost(4));

        // Example 2: Valid Rental Without Heavy Load
        Truck truck2 = new Truck("T002", "Kenworth", 100);
        truck2.setHeavyLoad(false);
        double expectedCost2 = 100 * 2 + 200; // Base + Deposit
        assertEquals(expectedCost2, truck2.calculateRentalCost(2));

        // Example 3: Zero-Day Rental
        Truck truck3 = new Truck("T003", "Peterbilt", 120);
        truck3.setHeavyLoad(false);
        double expectedCost3 = 200; // Deposit only
        assertEquals(expectedCost3, truck3.calculateRentalCost(0));

        // Example 4: Negative Base Rental Rate Throws Exception
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Truck("T004", "Volvo", -50);
        });

        // Trim the expected and actual messages to avoid whitespace issues
        assertEquals("Base rental rate must be positive".trim(), exception.getMessage().trim());
    }
}
