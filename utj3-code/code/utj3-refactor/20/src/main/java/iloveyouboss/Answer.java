/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

public record Answer(Question question, Object matchingValue) {
    public String questionText() {
        return question.text();
    }

    public boolean match(Answer otherAnswer) {
        return matchingValue.equals(otherAnswer.matchingValue);
    }
}
