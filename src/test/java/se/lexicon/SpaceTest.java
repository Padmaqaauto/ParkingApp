package se.lexicon;

import org.junit.jupiter.api.Test;
import se.lexicon.SpaceStatus;

import static org.junit.jupiter.api.Assertions.*;

class SpaceStatusTest {

    @Test
    void shouldContainExpectedStatuses() {
        assertArrayEquals(
                new SpaceStatus[]{
                        SpaceStatus.AVAILABLE,
                        SpaceStatus.OCCUPIED
                },
                SpaceStatus.values()
        );
    }
}