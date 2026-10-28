/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

import java.util.HashMap;
import java.util.Map;

public class Profile {
    private final Map<String,Answer> answers = new HashMap<>();
    private final String name;
    private int score;

    public Profile(String name) {
        this.name = name;
    }

    public void add(Answer... newAnswers) {
        for (var answer: newAnswers)
            answers.put(answer.questionText(), answer);
    }

    public boolean matches(Criteria criteria) {
        var matcher = new Matcher(criteria, answers);
        score = matcher.score();
        return matcher.isMatchFor(criteria);
    }

    public int score() {
        return score;
    }

    @Override
    public String toString() {
        return name;
    }
}
