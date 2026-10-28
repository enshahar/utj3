/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Profile {
   private final String id;
   private final Map<String,Answer> answers = new HashMap<>();
   private int score;

   public Profile(String id) {
      this.id = id;
   }

   public String getId() {
      return id;
   }

   public void add(Answer answer) {
      answers.put(answer.getQuestionText(), answer);
   }

   public boolean matches(Criteria criteria) {
      var matchSet = createMatchSet(criteria);
      return matchSet.matches();
   }

   public int score(Criteria criteria) {
      var matchSet = createMatchSet(criteria);
      return matchSet.getScore();
   }

   public MatchSet createMatchSet(Criteria criteria) {
      return new MatchSet(id, answers, criteria);
   }

   @Override
   public String toString() {
     return id;
   }

   public List<Answer> find(Predicate<Answer> pred) {
      return answers.values().stream()
         .filter(pred)
         .toList();
   }
}
