package se.lexicon.parking.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.ReservationStatus;
import se.lexicon.SpaceStatus;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    private Person person;
    private Vehicle vehicle;
    private ParkingSpace parkingSpace;
    private Reservation reservation;
    private LocalDateTime startTime;

    @BeforeEach
    void setUp() {
        person = new Person("John", "123456789");
        vehicle = new Vehicle("ABC123", person);
        parkingSpace = new ParkingSpace("P15");

        startTime = LocalDateTime.of(2026, 10, 31, 10, 0);

        reservation = new Reservation(
                person,
                vehicle,
                parkingSpace,
                startTime,
                Duration.ofHours(2)
        );
    }

    @Test
    void shouldCreateReservationWithCorrectDetails() {
        assertNotNull(reservation.getReservationID());
        assertEquals(person, reservation.getPerson());
        assertEquals(vehicle, reservation.getVehicle());
        assertEquals(parkingSpace, reservation.getParkingSpace());
    }

    @Test
    void shouldCalculateExpectedEndTime() {
        LocalDateTime expectedEndTime = startTime.plusHours(2);

        assertEquals(expectedEndTime, reservation.getExpectedEndTime());
    }

    @Test
    void shouldHaveActiveStatusWhenCreated() {
        assertEquals(ReservationStatus.ACTIVE, reservation.getStatus());
    }

    @Test
    void shouldHaveNullActualEndTimeWhenCreated() {
        assertNull(reservation.getActualEndTime());
    }

    @Test
    void shouldCompleteReservation() {
        reservation.complete();

        assertEquals(ReservationStatus.COMPLETED, reservation.getStatus());
        assertNotNull(reservation.getActualEndTime());
        assertEquals(SpaceStatus.AVAILABLE, parkingSpace.getStatus());
    }
}