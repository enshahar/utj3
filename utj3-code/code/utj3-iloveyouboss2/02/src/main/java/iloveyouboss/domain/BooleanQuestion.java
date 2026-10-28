/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

import java.io.Serial;
import java.util.*;

@Entity
@DiscriminatorValue(value="boolean")
public class BooleanQuestion extends Question {
   @Serial
   private static final long serialVersionUID = 1L;

   public BooleanQuestion() {}
   public BooleanQuestion(String text) {
      super(text);
   }

   @Override
   @ElementCollection
   public List<String> getAnswerChoices() {
      return List.of("No", "Yes");
   }

   @Override
   public boolean match(int expected, int actual) {
      return expected == actual;
   }
}
