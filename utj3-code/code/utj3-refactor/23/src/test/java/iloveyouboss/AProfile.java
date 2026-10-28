/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AProfile {
    Question question = new Question("?", new String[] {"Y","N"}, 1);
    Profile profile = new Profile("x");

    @Test
    void supportsAddingIndividualAnswers() {
        var answer = new Answer(question, "Y");

        profile.add(answer);

        assertEquals(List.of(answer), profile.answers());
    }
}
