/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Backslog {
   static class Math {
      static int factorial(int number) {
         var result = 1;
         while (number > 1) {
            result *= number;
            number--;
         }
         return result;
      }

      static int cube(int number) {
         return number * number * number;
      }
   }

   static class Strings {
      static String initial(String s) {
         if (s.length() <= 1) return s;
         return Character.toUpperCase(s.charAt(0)) + ".";
      }
   }

   static class Loops {
      static String toLowerCamel(String snakeCaseIdentifier) {
         var words = snakeCaseIdentifier.split("_");
         return words[0].toLowerCase() +
            Arrays.stream(words)
               .skip(1)
               .map(StringUtils::capitalize)
               .collect(Collectors.joining());
      }

      static List<String> namePairs(String sentence) {
         var results = new ArrayList<String>();
         var words = sentence.split(" ");
         for (var i = 0; i < words.length - 1; i++) {
            var thisWord = words[i];
            var thatWord = words[i + 1];
            if (Character.isUpperCase(thisWord.charAt(0)) &&
               Character.isUpperCase(thatWord.charAt(0))) {
               results.add(thisWord + " " + thatWord);
            }
         }
         return results;
      }
   }
}