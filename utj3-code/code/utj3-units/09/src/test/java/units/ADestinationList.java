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
import org.junit.jupiter.api.Nested;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static units.FixedLocation.Heading.East;
import static units.FixedLocation.Heading.North;

class ADestinationList {
   static final FixedLocation ORIGIN = new FixedLocation(0, 0, East);
   static final FixedLocation NORTHEAST = new FixedLocation(3, 3, North);
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
      list.add(ORIGIN);
      list.add(NORTHEAST);

      assertEquals(List.of(ORIGIN, NORTHEAST), list.getLocations());
   }

   @Test
   void doesNotAddLocationWhenAlreadyContained() {
      list.add(ORIGIN);
      list.add(NORTHEAST);

      list.add(ORIGIN);

      assertEquals(List.of(ORIGIN, NORTHEAST), list.getLocations());
   }

   @Test
   void doesNotAddLocationAlreadyContained() {
      list.add(new FixedLocation(0, 0, East));
      list.add(new FixedLocation(3, 3, North));

      list.add(new FixedLocation(0, 0, East));

      assertEquals(
         List.of(new FixedLocation(0, 0, East),
                 new FixedLocation(3, 3, North)),
         list.getLocations());
   }

   @Nested
   class MoveLocationsWithHeading {
      @Test
      void updatesMatchingLocationsWithNewCoordinates() {
         list.add(new FixedLocation(0, 0, East));
         list.add(new FixedLocation(1, 1, North));

         list.moveLocationsWithHeading(East, 2, 3);

         assertEquals(List.of(
               new FixedLocation(2, 3, East),
               new FixedLocation(1, 1, North)),
            list.getLocations());
      }
   }

   @Nested
   class RemoveLocationsFurtherThan {
      @Test
      void retainsLocationsLessThanDistance() {
         list.add(new FixedLocation(0, 5, North));
         list.add(new FixedLocation(0, 10, North));
         list.add(new FixedLocation(0, 15, North));

         list.removeLocationsFurtherThan(0, 0, 9);

         assertEquals(List.of(
               new FixedLocation(0, 5, North)),
            list.getLocations());
      }
   }
}
