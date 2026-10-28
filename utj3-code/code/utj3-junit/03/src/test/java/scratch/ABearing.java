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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ABearing {
   @Test
   void throwsWhenValueTooLarge() {
      assertThrows(BearingOutOfRangeException.class,
         () -> new Bearing(Bearing.MAX + 1));
   }

   @Test
   void answersValidBearing() {
      assertEquals(Bearing.MAX, new Bearing(Bearing.MAX).value());
   }

   @Nested
   class AngleTo {
      @Test
      void isDifferenceFromOtherBearingValue() {
         assertEquals(3, new Bearing(15).angleTo(new Bearing(12)));
      }

      @Test
      void isNegativeWhenThisBearingSmaller() {
         assertEquals(-3, new Bearing(12).angleTo(new Bearing(15)));
      }
   }
}
