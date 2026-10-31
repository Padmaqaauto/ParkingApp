package se.lexicon.parking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void shouldCreateVehicleWithCorrectDetails() {
        Person owner = new Person("John", "123456789");

        Vehicle vehicle = new Vehicle("ABC123", owner);

        assertEquals("ABC123", vehicle.getRegistrationNumber());
        assertEquals(owner, vehicle.getVehicleOwner());
    }

    @Test
    void shouldAddVehicleToOwnersVehicleList() {
        Person owner = new Person("John", "123456789");
        Vehicle vehicle = new Vehicle("ABC123", owner);

        owner.addVehicle(vehicle);

        assertTrue(owner.getVehicles().contains(vehicle));
    }

    @Test
    void shouldReturnEmptyReservationsInitially() {
        Person owner = new Person("John", "123456789");
        Vehicle vehicle = new Vehicle("ABC123", owner);

        assertTrue(vehicle.getReservations().isEmpty());
    }
}