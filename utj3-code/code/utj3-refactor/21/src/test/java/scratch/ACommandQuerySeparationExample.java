/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ACommandQuerySeparationExample {
    // @ExpectToFail
    @Test
    void partitionsIntegerListIntoOddsAndEvens() {
        var list = List.of(1, 2, 3, 4, 5, 6);

        var evens = new ArrayList<Integer>();
        var odds = new ArrayList<Integer>();
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            var element = iterator.next();
            System.out.println("each " + element);
            if (element % 2 == 0) {
                System.out.println("even item: " + element);
                evens.add(element);
            } else {
                System.out.println("odd item:" + iterator.next());
                odds.add(element);
            }
        }

        assertEquals(List.of(1, 3, 5), odds);
        assertEquals(List.of(2, 4, 6), evens);
    }

    @Test
    void partitionsIntegerListIntoOddsAndEvensCorrectly() {
        var list = List.of(1, 2, 3, 4, 5, 6);

        var evens = new ArrayList<Integer>();
        var odds = new ArrayList<Integer>();
        var iterator = new Jefferator(list);
        while (iterator.hasNext()) {
            iterator.next();
            var element = iterator.current();
            System.out.println("each " + element);
            if (element % 2 == 0) {
                System.out.println("even item: " + element);
                evens.add(element);
            } else {
                System.out.println("odd item:" + iterator.current());
                odds.add(element);
            }
        }

        assertEquals(List.of(1, 3, 5), odds);
        assertEquals(List.of(2, 4, 6), evens);
    }
}
