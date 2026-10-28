/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public record Booking(
        String name,
        int age,
        LocalDateTime departureDate,
        List<String> itinerary) {
   private static final Set<String> AIRPORT_CODES = Set.of(
      "COS", "DEN", "DUB", "PRG");

   public List<String> validate() {
      var errorMessages = new ArrayList<String>();
      if (name == null || name.trim().isEmpty())
         errorMessages.add("Name is empty");
      if (age < 18)
         errorMessages.add("Minor cannot fly unaccompanied");
      if (!departureDate.isAfter(LocalDateTime.now()))
         errorMessages.add("Too late!");
      if (itinerary.size() < 2)
         errorMessages.add("Itinerary needs 2+ airport codes");
      if (!itinerary.stream().allMatch(
              airportCode -> AIRPORT_CODES.contains(airportCode)))
         errorMessages.add("Itinerary contains invalid airport code");
      return errorMessages;
   }
}
