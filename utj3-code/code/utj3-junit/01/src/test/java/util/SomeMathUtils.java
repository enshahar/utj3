/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.MathUtils.fastHalf;

public class SomeMathUtils {
    @Nested
    class FastHalf {
        @Test
        void isZeroWhenZero() {
            assertEquals(0, fastHalf(0));
        }

        @Test
        void roundsDownToZeroWhenOne() {
            assertEquals(0, fastHalf(1));
        }

        @Test
        void dividesEvenlyWhenEven() {
            assertEquals(11, fastHalf(22));
        }

        @Test
        void roundsDownWhenOdd() {
            assertEquals(10, fastHalf(21));
        }

        @Test
        void handlesNegativeNumbers() {
            assertEquals(-2, fastHalf(-4));
        }

        @Test
        void handlesLargeNumbers() {
            var number = 489_935_889_934_389_890L;
            assertEquals(244_967_944_967_194_945L, fastHalf(number));
            assertEquals(number, fastHalf(number) * 2);
        }
    }
}
