/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units.validations;

import units.Booking;
import units.Validation;
import java.util.Set;

public class ItineraryAirports implements Validation {
   private static final Set<String> AIRPORT_CODES = Set.of(
      "COS", "DEN", "DUB", "PRG");
   private final Booking booking;

   public ItineraryAirports(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return !booking.itinerary().stream().allMatch(
         airportCode -> AIRPORT_CODES.contains(airportCode));
   }

   @Override
   public String errorMessage() {
      return "Itinerary contains invalid airport code";
   }
}
