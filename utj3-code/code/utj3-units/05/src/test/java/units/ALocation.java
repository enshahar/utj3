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
import static units.Location.Heading.*;

public class ALocation {
   @Test
   void increasesYCoordinateWhenMovingNorth() {
      var location = new Location(0, 0, North);

      location.move(42);

      assertEquals(new Location(0, 42, North), location);
   }

   @Test
   void increasesXCoordinateWhenMovingEast() {
      var location = new Location(-2, 0, East);

      location.move(5);

      assertEquals(new Location(3, 0, East), location);
   }

   @Test
   void decreasesYCoordinateWhenMovingSouth() {
      var location = new Location(-2, 5, South);

      location.move(9);

      assertEquals(new Location(-2, -4, South), location);
   }

   @Test
   void decreasesXCoordinateWhenMovingWest() {
      var location = new Location(-2, 5, West);

      location.move(12);

      assertEquals(new Location(-14, 5, West), location);
   }
}
