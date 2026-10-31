package se.lexicon.parking.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAreaTest {

    private ParkingArea parkingArea;

    @BeforeEach
    void setUp() {
        parkingArea = new ParkingArea("Lexicon Parking", 20);
    }

    @Test
    void shouldCreateParkingAreaWithCorrectDetails() {
        assertEquals("Lexicon Parking", parkingArea.getName());
        assertEquals(20, parkingArea.getCapacity());
    }

    @Test
    void shouldFindExistingParkingSpace() {
        ParkingSpace space = parkingArea.getSpaceById("P15");

        assertNotNull(space);
        assertEquals("P15", space.getSpaceId());
    }

    @Test
    void shouldReturnNullForNonExistingParkingSpace() {
        ParkingSpace space = parkingArea.getSpaceById("P25");

        assertNull(space);
    }
}