/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import util.ExpectToFail;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.Month.MAY;
import static java.util.regex.Pattern.compile;
import static org.assertj.core.api.Assertions.assertThat;

public class SomeAssertJExamples {
   String name = "my big fat acct";

   @Nested
   class StringMatching {
      @Test
      void equality() {
         assertThat(name).isEqualTo("my big fat acct");
      }

      @Test
      void notEqual() {
         assertThat(name).isNotEqualTo("plunderings");
      }

      @Test
      void type() {
         assertThat(name).isInstanceOf(String.class);
      }

      @Test
      void regex() {
         assertThat(name).containsPattern(
            compile("\\s+(big fat|small)\\s+"));
      }

      @Test
      void chainedMatchers() {
         assertThat(name)
            .startsWith("my")
            .endsWith("acct");
      }

      @ExpectToFail
      @Test
      public void matchesFailure() {
         assertThat(name).containsPattern(
            compile("\\s+(large|little)\\s+"));
      }
   }

   @Nested
   class ListContainmentAndSubsetPredicates {
      @ExpectToFail
      @Test
      public void simpleListTests() {
         var names = List.of("Moe", "Larry", "Curly");

         assertThat(names).contains("Curly");
         assertThat(names).contains("Curly", "Moe");
         assertThat(names).anyMatch(name -> name.endsWith("y"));
         assertThat(names).allMatch(name -> name.length() < 6);

         assertThat(names).allMatch(name -> name.length() < 5);
      }
   }

   @Nested
   class Extraction {
      private List<Flight> flights;

      record Segment(String origin, String destination, int distance) {
         boolean includes(String airport) {
            return origin.equals(airport) || destination.equals(airport);
         }
      }

      record Flight(Segment segment, LocalDateTime dateTime) {
         Flight(String origin, String destination,
                int distance, LocalDateTime dateTime) {
            this(new Segment(origin, destination, distance), dateTime);
         }

         boolean includes(String airport) {
            return segment.includes(airport);
         }
      }

      @BeforeEach
      void setup() {
         var dateTime = LocalDateTime.of(2025, MAY, 1, 9, 30);
         flights = List.of(
            new Flight("BWI", "ORD", 621, dateTime),
            new Flight("BWI", "DEN", 1487, dateTime),
            new Flight("BWI", "LGA", 185, dateTime),
            new Flight("BWI", "LAX", 2324, dateTime),
            new Flight("DEN", "ORD", 886, dateTime),
            new Flight("DEN", "LGA", 1615, dateTime),
            new Flight("DEN", "LAX", 861, dateTime)
         );
      }

      @Test
      void filterAndExtract() {
         // ...
         assertThat(flights)
            .filteredOn(flight -> flight.includes("DEN"))
            .extracting("segment.distance", Integer.class)
            .allMatch(distance -> distance < 1700);
      }
   }
}
