/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ANameValidator {
   class NameValidationException extends RuntimeException {}

   class NameValidator {
      long commaCount(String s) {
         return s.chars().filter(ch -> ch == ',').count();
      }

      void validate(String name) {
         if (name.isEmpty() ||
            commaCount(name) > 1)
            throw new NameValidationException();
      }
   }

   NameValidator validator = new NameValidator();

   @Test
   void throwsWhenNameIsEmpty() {
      assertThrows(NameValidationException.class, () ->
         validator.validate(""));
   }

   @Test
   void throwsWhenNameContainsMultipleCommas() {
      assertThrows(NameValidationException.class, () ->
         validator.validate("Langr, Jeffrey,J."));
   }

   @Test
   void doesNotThrowWhenNoErrorsExist() {
      assertDoesNotThrow(() ->
         validator.validate("Langr, Jeffrey J."));
   }
}
