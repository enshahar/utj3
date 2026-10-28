/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

public class StringUtils {
   static String capitalize(String word) {
      if (word.isEmpty()) return "";

      var head = word.substring(0, 1);
      var tail = word.substring(1);
      return head.toUpperCase() + tail.toLowerCase();
   }
}
