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
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnItinerarySize {
   @Test
   void isInvalidWhenItineraryHasFewerThanTwoAirportCodes() {
      var booking = new Booking("", 0, null, List.of("COS"));

      var isInvalid = new ItinerarySize(booking).isInvalid();

      assertTrue(isInvalid);
   }

   @Test
   void isNotInvalidWhenItineraryHasAtLeastTwoAirportCodes() {
      var booking = new Booking("", 0, null, List.of("COS", "DUB"));

      var isInvalid = new ItinerarySize(booking).isInvalid();

      assertFalse(isInvalid);
   }
}
