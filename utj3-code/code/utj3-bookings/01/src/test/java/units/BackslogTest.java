/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static units.Backslog.Loops.namePairs;
import static units.Backslog.Math.cube;
import static units.Backslog.Math.factorial;
import static units.Backslog.Strings.initial;

public class BackslogTest {
   @Nested
   class Factorial {
      @Test
      void for1() {
         assertEquals(1, factorial(1));
      }
      @Test
      void for2() {
         assertEquals(2, factorial(2));
      }
      @Test
      void for3() {
         assertEquals(6, factorial(3));
      }
      @Test
      void for4() {
         assertEquals(24, factorial(4));
      }
      @Test
      void for5() {
         assertEquals(120, factorial(5));
      }
   }

   @Nested
   class Cube {
      @Test
      void zero() {
         assertEquals(0, cube(0));
      }

      @Test
      void one() {
         assertEquals(1, cube(1));
      }

      @Test
      void two() {
         assertEquals(8, cube(2));
      }
   }

   @Nested
   class Initial {
      @Test
      void returnsEmptyStringWhenEmpty() {
         assertEquals("", initial(""));
      }

      @Test
      void returnsSameWhenSingleCharacter() {
         assertEquals("S", initial("S"));
      }

      @Test
      void returnsInitializedWhenLengthExceeds1() {
         assertEquals("S.", initial("Smith"));
      }
   }


   @Nested
   class NamePairs {
      @Test
      void returnsEmptyListWhenNoPairs() {
         assertEquals(Collections.emptyList(), namePairs("hello my name is"));
      }

      @Test
      void returnsSingleStringWhenMatchingPairFound() {
         assertEquals(List.of("Luis Buñuel"), namePairs("hello my name is Luis Buñuel"));
      }

      @Test
      void returnsPairWhenAtBeginningOfString() {
         assertEquals(List.of("Luis Buñuel"), namePairs("Luis Buñuel was here"));
      }

      @Test
      void returnsMultiplePairs() {
         assertEquals(List.of("Luis Buñuel", "Buñuel Portolés"), namePairs("hello my name is Luis Buñuel Portolés"));
      }
   }
}
