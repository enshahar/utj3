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
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ABooking {
   @Test
   void validates() {
      var booking = new Booking("", 21, null, null);
      final var passedInValidations = new ArrayList<>();
      final var returnedResults = List.of("a");

      var results = booking.validate(new Validator() {
         @Override
         public List<String> validate(List<Validation> validations) {
            passedInValidations.addAll(validations);
            return returnedResults;
         }
      });

      assertEquals(returnedResults, results);
   }
}
