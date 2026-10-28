/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AStringSet {
   @Nested
   class FindViaPredicate {
      StringSet set = new StringSet();

      @Test
      void returnsMatchingStrings() {
         set.add("alpha");
         set.add("beta");
         set.add("gamma");
         set.add("delta");
         set.add("epsilon");

         var results = set.find(s -> s.length() > 4);

         var inverseResults = set.strings().stream()
            .filter(s -> s.length() <= 4)
            .collect(Collectors.toSet());
         results.addAll(inverseResults);
         assertEquals(set.strings(), results);
      }
   }
}
