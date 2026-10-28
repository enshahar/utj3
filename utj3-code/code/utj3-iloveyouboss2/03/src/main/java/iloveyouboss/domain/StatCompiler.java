/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

import iloveyouboss.persistence.QuestionRepository;
import java.util.*;
import java.util.concurrent.atomic.*;

public class StatCompiler {
   private QuestionRepository repository;

   public Map<String, Map<Boolean, AtomicLong>> responsesByQuestion(
         List<BooleanAnswer> answers) {
      var responses = new HashMap<Long, Map<Boolean, AtomicLong>>();
      answers.forEach(answer -> {
         var id = answer.questionId();
         Map<Boolean, AtomicLong> histogram;
         if (responses.containsKey(id))
            histogram = responses.get(id);
         else
            histogram = Map.of(
               Boolean.FALSE, new AtomicLong(0),
               Boolean.TRUE, new AtomicLong(0));
            responses.put(id, histogram);
         histogram.get(answer.value()).getAndIncrement();
      });

      var textResponses = new HashMap<String, Map<Boolean, AtomicLong>>();
      responses.keySet().forEach(id ->
         textResponses.put(repository.find(id).getText(), responses.get(id)));
      return textResponses;
   }
}
