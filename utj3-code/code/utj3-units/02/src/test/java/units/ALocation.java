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
import static units.Location.Heading.North;

public class ALocation {
   @Test
   void increasesYCoordinateWhenMovingNorth() {
      var location = new Location(0, 0, North);

      location.move(42);

      assertEquals(0, location.getX());
      assertEquals(42, location.getY());
      assertEquals(North, location.getHeading());
   }
}
