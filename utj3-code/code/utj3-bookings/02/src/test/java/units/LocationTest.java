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

class LocationTest {
   @Test
   void moveEastIncreasesX() {
      var point = new Location(2, 3, East);
      point.move(3);
      assertEquals(new Location(5, 3, East), point);
   }

   @Test
   void moveSouthDecreasesY() {
      var point = new Location(2, 3, South);
      point.move(5);
      assertEquals(new Location(2, -2, South), point);
   }

   @Test
   void moveWestDecreasesX() {
      var point = new Location(1, 3, West);
      point.move(5);
      assertEquals(new Location(-4, 3, West), point);
   }

   @Test
   void moveNorthIncreasesY() {
      var point = new Location(1, -2, North);
      point.move(8);
      assertEquals(new Location(1, 6, North), point);
   }
}