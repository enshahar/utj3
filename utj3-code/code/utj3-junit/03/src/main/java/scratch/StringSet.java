/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toSet;

public class StringSet {
   private final Set<String> strings = new HashSet<>();

   public void add(String string) {
      if (string == null) throw new IllegalArgumentException();
      strings.add(string);
   }

   Set<String> strings() {
      return strings;
   }

   public Set<String> find(Predicate<String> predicate) {
      return strings.stream().filter(predicate).collect(toSet());
   }
}
