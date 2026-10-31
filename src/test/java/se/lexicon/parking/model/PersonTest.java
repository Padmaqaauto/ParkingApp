package se.lexicon.parking.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("John", "123456789");
    }

    @Test
    void shouldCreatePersonWithCorrectDetails() {
        assertEquals("John", person.getName());
        assertEquals("123456789", person.getPhoneNumber());
    }

    @Test
    void shouldAddVehicleToPerson() {
        Vehicle vehicle = new Vehicle("ABC123", person);

        person.addVehicle(vehicle);

        assertEquals(1, person.getVehicles().size());
        assertTrue(person.getVehicles().contains(vehicle));
    }

    @Test
    void shouldReturnCopyOfVehiclesList() {
        Vehicle vehicle = new Vehicle("ABC123", person);
        person.addVehicle(vehicle);

        ArrayList<Vehicle> vehicles = person.getVehicles();

        assertEquals(1, person.getVehicles().size());
    }

    @Test
    void shouldReturnEmptyReservationsInitially() {
        assertTrue(person.getReservations().isEmpty());
    }
}