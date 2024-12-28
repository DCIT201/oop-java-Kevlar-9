package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    @Test
    void testCarRentalCost() {
        Car car = new Car("C123", "Toyota Corolla", 50);
        assertEquals(250, car.calculateRentalCost(4));
    }

    @Test
    void testCarAvailability() {
        Car car = new Car("C123", "Toyota Corolla", 50);
        assertTrue(car.isAvailableForRental());
        car.setAvailable(false);
        assertFalse(car.isAvailableForRental());
    }
}