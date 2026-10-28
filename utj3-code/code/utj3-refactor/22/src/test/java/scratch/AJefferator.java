/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AJefferator {
    @Nested
    class WhenCreated {
        @Test
        void hasNextIsFalseWhenListEmpty() {
            var list = new ArrayList<Integer>();

            var iterator = new Jefferator(list);

            assertFalse(iterator.hasNext());
        }

        @Test
        void hasNextIsTrueWhenListNonEmpty() {
            var list = List.of(42);

            var iterator = new Jefferator(list);

            assertTrue(iterator.hasNext());
        }

        @Test
        void throwsWhenEmptyAndRequestingCurrent() {
            var list = new ArrayList<Integer>();

            var iterator = new Jefferator(list);

            var thrown = assertThrows(RuntimeException.class, () -> iterator.current());
            assertEquals("iterator out of bounds", thrown.getMessage());
        }

        @Test
        void returnsFirstElementAsCurrent() {
            var list = List.of(42);
            var iterator = new Jefferator(list);

            iterator.next();

            assertEquals(42, iterator.current());
        }

        @Test
        void iteratesEntireList() {
            var results = new ArrayList<Integer>();
            var list = List.of(2, 4, 8, 16);
            var iterator = new Jefferator(list);

            while (iterator.hasNext()) {
                iterator.next();
                var element = iterator.current();
                results.add(element);
            }

            assertEquals(List.of(2, 4, 8, 16), results);
        }
    }
}