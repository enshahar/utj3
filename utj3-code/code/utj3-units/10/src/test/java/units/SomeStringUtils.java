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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static units.StringUtils.capitalize;

public class SomeStringUtils {
   @Nested
   class Capitalize {
   @Test
   void returnsEmptyStringWhenEmpty() {
      assertEquals("", capitalize(""));
   }

      @Test
      void uppercasesSingleLetter() {
         assertEquals("A", capitalize("a"));
      }

      @Test
      void uppercasesFirstLetterOfLowercaseWord() {
         assertEquals("Alpha", capitalize("alpha"));
      }

      @Test
      void lowercasesRemainderOfLetters() {
         assertEquals("Omega", capitalize("OMEGA"));
      }
   }
}
