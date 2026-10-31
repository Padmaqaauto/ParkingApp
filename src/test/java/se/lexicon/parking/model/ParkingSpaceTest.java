package se.lexicon.parking.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.lexicon.SpaceStatus;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceTest {

    private ParkingSpace parkingSpace;

    @BeforeEach
    void setUp() {
        parkingSpace = new ParkingSpace("P15");
    }

    @Test
    void shouldCreateParkingSpaceWithCorrectId() {
        assertEquals("P15", parkingSpace.getSpaceId());
    }

    @Test
    void shouldBeAvailableWhenCreated() {
        assertEquals(SpaceStatus.AVAILABLE, parkingSpace.getStatus());
    }

    @Test
    void shouldChangeStatusToOccupied() {
        parkingSpace.setStatus(SpaceStatus.OCCUPIED);

        assertEquals(SpaceStatus.OCCUPIED, parkingSpace.getStatus());
    }

    @Test
    void shouldReturnEmptyReservationsInitially() {
        assertTrue(parkingSpace.getReservations().isEmpty());
    }
}