/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static units.FixedLocation.Heading.East;
import static units.FixedLocation.Heading.North;

class ADestinationList {
   private DestinationList list;

   @BeforeEach
   void create() {
      list = new DestinationList();
   }

   @Test
   void isEmptyWhenCreated() {
      assertTrue(list.getLocations().isEmpty());
   }

   static final FixedLocation ORIGIN = new FixedLocation(0, 0, East);
   static final FixedLocation NORTHEAST = new FixedLocation(3, 3, North);

   @Test
   void allowsAddingLocations() {
      list.add(ORIGIN);
      list.add(NORTHEAST);

      assertEquals(List.of(ORIGIN, NORTHEAST), list.getLocations());
   }
}
