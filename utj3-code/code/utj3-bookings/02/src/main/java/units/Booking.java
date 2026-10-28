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
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

public record Booking(
        String name,
        int age,
        LocalDateTime departureDate,
        List<String> itinerary) {
   private static final Set<String> AIRPORT_CODES = Set.of(
      "COS", "DEN", "DUB", "PRG");

   interface Validation {
      boolean isInvalid();
      String errorMessage();
   }

   class NameRequired implements Validation {
      @Override
      public boolean isInvalid() {
         return name == null || name.trim().isEmpty();
      }

      @Override
      public String errorMessage() {
         return "이름이 비어 있다";
      }
   }

   class AgeMinimum implements Validation {
      @Override
      public boolean isInvalid() {
         return age < 18;
      }

      @Override
      public String errorMessage() {
         return "미성년자는 보호자 동반 없이 비행할 수 없다";
      }
   }

   class FutureDate implements Validation {
      @Override
      public boolean isInvalid() {
         return !departureDate.isAfter(LocalDateTime.now());
      }

      @Override
      public String errorMessage() {
         return "Too late!";
      }
   }

   class ItinerarySize implements Validation {
      @Override
      public boolean isInvalid() {
         return itinerary.size() < 2;
      }

      @Override
      public String errorMessage() {
         return "여정에 2개 이상의 공항 코드가 필요하다";
      }
   }

   class ItineraryAirports implements Validation {
      @Override
      public boolean isInvalid() {
         return !itinerary.stream().allMatch(
                 airportCode -> AIRPORT_CODES.contains(airportCode));
      }

      @Override
      public String errorMessage() {
         return "여정에 유효하지 않은 공항 코드가 포함됐다";
      }
   }

   public List<String> validate() {
      return asList(
         new NameRequired(),
         new AgeMinimum(),
         new FutureDate(),
         new ItinerarySize(),
         new ItineraryAirports()).stream()
            .filter(Validation::isInvalid)
            .map(Validation::errorMessage)
            .toList();
   }
}
