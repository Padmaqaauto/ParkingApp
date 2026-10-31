package se.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationStatusTest {

    @Test
    void shouldContainExpectedStatuses() {
        assertArrayEquals(
                new ReservationStatus[]{
                        ReservationStatus.ACTIVE,
                        ReservationStatus.COMPLETED
                },
                ReservationStatus.values()
        );
    }
}