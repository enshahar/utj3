/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

public record Answer(Question question, int i) {
   public Answer(Question question, String matchingValue) {
      this(question, question.indexOf(matchingValue));
   }
   
   public String getQuestionText() {
      return question.getText();
   }

   @Override
   public String toString() {
      return String.format("%s %s", question.getText(), question.getAnswerChoice(i));
   }

   public boolean match(Answer otherAnswer) {
      return question.match(i, otherAnswer.i);
   }
}
