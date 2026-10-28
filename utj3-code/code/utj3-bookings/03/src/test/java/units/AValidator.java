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
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AValidator {
   Validation passingValidation = new Validation() {
      @Override public boolean isInvalid() { return false; }
      @Override public String errorMessage() { return ""; }
   };

   Validation failingValidation = new Validation() {
      @Override public boolean isInvalid() { return true; }
      @Override public String errorMessage() { return "fail"; }
   };

   @Test
   void returnsEmptyListWhenAllValidationsPass() {
      assertEquals(Collections.emptyList(),
         new Validator().validate(List.of(passingValidation)));
   }

   @Test
   void returnsListOfFailingValidationMessages() {
      assertEquals(List.of(failingValidation.errorMessage()),
         new Validator().validate(List.of(
            failingValidation,
            passingValidation)));
   }
}
