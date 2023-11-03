package com.pluralsight;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @org.junit.jupiter.api.Test
    void getMake() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals("ford", vehicle1.getMake());

    }

    @org.junit.jupiter.api.Test
    void getModel() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals("git", vehicle1.getModel());
    }

    @org.junit.jupiter.api.Test
    void getVehicleType() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals("suv", vehicle1.getVehicleType());
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals("black", vehicle1.getColor());
    }

    @org.junit.jupiter.api.Test
    void getVin() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals(1, vehicle1.getVin());
    }

    @org.junit.jupiter.api.Test
    void getYear() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals(2023, vehicle1.getYear());

    }

    @org.junit.jupiter.api.Test
    void getOdometer() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals(0010234, vehicle1.getOdometer());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        Vehicle vehicle1 = new Vehicle(1, 2023, 0010234, 2344.12, "ford", "git", "suv", "black");
        assertEquals(2344.12, vehicle1.getPrice());
    }
}