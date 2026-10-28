/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import units.validations.*;
import java.time.LocalDateTime;
import java.util.List;
import static java.util.Arrays.asList;

public record Booking(
        String name,
        int age,
        LocalDateTime departureDate,
        List<String> itinerary) {

   public List<String> validate(Validator validator) {
      return validator.validate(validations());
   }

   List<Validation> validations() {
      return asList(
              new NameRequired(this),
              new AgeMinimum(this),
              new FutureDate(this),
              new ItinerarySize(this),
              new ItineraryAirports(this));
   }
}
