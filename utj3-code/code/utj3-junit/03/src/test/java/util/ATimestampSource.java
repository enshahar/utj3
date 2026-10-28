/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.Month.JANUARY;
import static java.time.Month.MARCH;
import static org.junit.jupiter.api.Assertions.*;

class TimestampSourceTest {
    static final LocalDateTime IDES_OF_MARCH =
        LocalDateTime.of(2025, MARCH, 15, 0, 0);
    static final LocalDateTime NEW_YEAR_START =
        LocalDateTime.of(2025, JANUARY, 1, 0, 0);

    @BeforeEach
    void clearTimestampSource() {
        TimestampSource.emptyQueue();
    }

    @Test
    void retrievesSinglePushedTime() {
        TimestampSource.queueNextTime(NEW_YEAR_START);

        assertEquals(TimestampSource.now(), NEW_YEAR_START);
    }

    @Test
    void retrievesMultiplePushedTimes() {
        TimestampSource.queueNextTime(NEW_YEAR_START);
        TimestampSource.queueNextTime(IDES_OF_MARCH);

        assertEquals(TimestampSource.now(), NEW_YEAR_START);
        assertEquals(TimestampSource.now(), IDES_OF_MARCH);
    }

    @Test
    void isNotExhaustedWhenTimeQueued() {
        TimestampSource.queueNextTime(NEW_YEAR_START);

        assertFalse(TimestampSource.isExhausted());
    }

    @Test
    void isExhaustedWhenNoTimeQueued() {
        assertTrue(TimestampSource.isExhausted());
        TimestampSource.queueNextTime(NEW_YEAR_START);

        TimestampSource.now();

        assertTrue(TimestampSource.isExhausted());
    }

    @Test
    void returnsCurrentTimeWhenQueueExhausted() {
        TimestampSource.queueNextTime(NEW_YEAR_START);
        var now = LocalDateTime.now();
        TimestampSource.now();

        var retrievedNow = TimestampSource.now();

        int millisThreshold = 100;
        assertTrue(millisBetween(retrievedNow, now) < millisThreshold);
    }

    private long millisBetween(LocalDateTime retrievedNow, LocalDateTime now) {
        return Duration.between(instant(retrievedNow), instant(now)).toMillis();
    }

    Instant instant(LocalDateTime dateTime) {
        return dateTime.atZone(ZoneId.systemDefault()).toInstant();
    }
}
