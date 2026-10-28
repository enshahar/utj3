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
         errorMessages.add("이름이 비어 있다");
      if (age < 18)
         errorMessages.add("미성년자는 보호자 동반 없이 비행할 수 없다");
      if (!departureDate.isAfter(LocalDateTime.now()))
         errorMessages.add("너무 늦었다!");
      if (itinerary.size() < 2)
         errorMessages.add("여정에 2개 이상의 공항 코드가 필요하다");
      if (!itinerary.stream().allMatch(
              airportCode -> AIRPORT_CODES.contains(airportCode)))
         errorMessages.add("여정에 유효하지 않은 공항 코드가 포함됐다");
      return errorMessages;
   }
}
