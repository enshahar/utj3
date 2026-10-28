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
import static units.FLocation.Heading.*;

class FLocationTest {
   @Test
   void moveEastIncreasesX() {
      assertEquals(new FLocation(5, 3, East),
         new FLocation(2, 3, East).move(3));
   }

   @Test
   void moveSouthDecreasesY() {
      assertEquals(new FLocation(2, -2, South),
         new FLocation(2, 3, South).move(5));
   }

   @Test
   void moveWestDecreasesX() {
      assertEquals(new FLocation(-4, 3, West),
         new FLocation(1, 3, West).move(5));
   }

   @Test
   void moveNorthIncreasesY() {
      assertEquals(new FLocation(1, 6, North),
         new FLocation(1, -2, North).move(8));
   }
}