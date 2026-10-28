/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static iloveyouboss.Weight.REQUIRED;

public class Matcher {
    private final Criteria criteria;
    private final Map<String, Answer> answers;

    public Matcher(Criteria criteria, Answer... matcherAnswers) {
        this.criteria = criteria;
        this.answers = toMap(matcherAnswers);
    }

    private Map<String, Answer> toMap(Answer[] answers) {
        return Stream.of(answers).collect(
            Collectors.toMap(Answer::questionText, answer -> answer));
    }

    public Matcher(Criteria criteria, Map<String, Answer> answers) {
        this.criteria = criteria;
        this.answers = answers;
    }

    public boolean matches() {
        return allRequiredCriteriaMet() && anyMatches();
    }

    private boolean allRequiredCriteriaMet() {
        return criteria.stream()
            .filter(criterion -> criterion.weight() == REQUIRED)
            .allMatch(criterion ->
                criterion.isMatch(profileAnswerMatching(criterion)));
    }

    private boolean anyMatches() {
        return criteria.stream()
            .anyMatch(criterion ->
                criterion.isMatch(profileAnswerMatching(criterion)));
    }

    private Answer profileAnswerMatching(Criterion criterion) {
        return answers.get(criterion.questionText());
    }

    public int score() {
        return criteria.stream()
            .filter(criterion ->
                criterion.isMatch(profileAnswerMatching(criterion)))
            .mapToInt(criterion -> criterion.weight().value())
            .sum();
    }
}
