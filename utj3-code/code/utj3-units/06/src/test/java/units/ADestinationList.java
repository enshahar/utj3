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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

   @Test
   void allowsAddingLocations() {
      list.add(new FixedLocation(1, 2, North));
      list.add(new FixedLocation(1, 3, East));

      assertEquals(
         List.of(
            new FixedLocation(1, 2, North),
            new FixedLocation(1, 3, East)),
         list.getLocations());
   }
}
