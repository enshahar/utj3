/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

// derived from https://www.developer.com/design/working-with-design-patterns-flyweight/
public class ATimePool {
   @BeforeEach
   void resetPool() {
      TimePool.reset();
   }

   @Test
   void getReturnsTimeInstance() {
      byte four = 4;
      byte twenty = 20;
      assertEquals(new Time(four, twenty), TimePool.get(four, twenty));
   }

   @Test
   void getWithSameValuesReturnsSharedInstance() {
      byte ten = 10;
      byte five = 5;
      var firstRetrieved = TimePool.get(ten, five);

      var secondRetrieved = TimePool.get(ten, five);

      assertSame(firstRetrieved, secondRetrieved);
   }
}
