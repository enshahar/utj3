/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    private final List<Answer> answers = new ArrayList<>();
    private final String name;

    public Profile(String name) {
        this.name = name;
    }

    public void add(Answer... newAnswers) {
        for (var answer: newAnswers)
            answers.add(answer);
    }

    public List<Answer> answers() {
        return answers;
    }

    public String name() {
        return name;
    }
}
