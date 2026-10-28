/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import static iloveyouboss.domain.Weight.REQUIRED;
import static java.util.stream.IntStream.range;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AProfileMatcher {
   ProfileMatcher matcher = new ProfileMatcher();

   @Test
   void returnsScoreForAllProfiles()
         throws ExecutionException, InterruptedException {
      var questions = createQuestions(50);
      int profileCount = 500;
      var half = profileCount / 2;
      range(0, half)
         .forEach(id ->
            matcher.addProfile(createProfile(
               questions, id, i -> nonMatchingAnswer(questions.get(i)))));
      range(half, profileCount)
         .forEach(id ->
            matcher.addProfile(createProfile(
               questions, id, i -> matchingAnswer(questions.get(i)))));
      var criteria = createCriteria(questions);

      var results = matcher.scoreProfiles(criteria);

      assertEquals(half,
         results.values().stream().filter(score -> score == 0).count());
      assertEquals(half,
         results.values().stream().filter(score -> score > 0).count());
   }

   private Profile createProfile(
      List<BooleanQuestion> questions, int id, Function<Integer, Answer> answerFunction) {
      var profile = new Profile(String.valueOf(id));
      range(0, questions.size()).forEach(i -> profile.add(answerFunction.apply(i)));
      return profile;
   }

   private Criteria createCriteria(List<BooleanQuestion> questions) {
      var questionCount = questions.size();
      var criteria = new Criteria();
      range(0, 5).forEach(i ->
         criteria.add(new Criterion(
            matchingAnswer(questions.get(i)), REQUIRED)));
      range(5, questionCount).forEach(i ->
         criteria.add(new Criterion(
            matchingAnswer(questions.get(i)), Weight.WOULD_PREFER)));
      return criteria;
   }

   private List<BooleanQuestion> createQuestions(int questionCount) {
      return range(0, questionCount)
         .mapToObj(i -> new BooleanQuestion("question " + i))
         .toList();
   }

   Answer matchingAnswer(Question question) {
      return new Answer(question, Bool.TRUE);
   }

   Answer nonMatchingAnswer(Question question) {
      return new Answer(question, Bool.FALSE);
   }
}
