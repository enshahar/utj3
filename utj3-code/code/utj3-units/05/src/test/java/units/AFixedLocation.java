/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static units.Heading.*;

public class AFixedLocation {
   public static final Coordinate ZERO_ZERO = new Coordinate(0, 0);

   @Test
   void changesCoordinateOnMove() {
      assertEquals(new Coordinate(0, 42),
         new FixedLocation(ZERO_ZERO, North).move(42).coordinate());
   }

   @Test
   void doesNotChangeHeadingOnMove() {
      assertEquals(North,
         new FixedLocation(ZERO_ZERO, North).move(42).heading());
   }
}
