/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units.validations;

import org.junit.jupiter.api.Test;
import units.Booking;
import static org.junit.jupiter.api.Assertions.*;

public class AnAgeMinimum {
   @Test
   void isInvalidWhenAgeBelow18() {
      var booking = new Booking("", 17, null, null);

      var isInvalid = new AgeMinimum(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenAgeAtLeast18() {
      var booking = new Booking("", 18, null, null);

      var isInvalid = new AgeMinimum(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
