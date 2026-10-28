/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NameNormalizer {

   public static String normalizeName(String name) {
      var nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      var lastName = nameParts[nameParts.length - 1];
      var firstName = nameParts[0];
      var middleNames =
         Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);

      return formatLastNameFirst(lastName, firstName, middleNames);
   }

   private static String formatLastNameFirst(
      String lastName, String firstName, String[] middleNames) {
      var middleInitials = Arrays.stream(middleNames)
         .map(NameNormalizer::extractInitial)
         .collect(Collectors.joining(" "));

      return middleInitials.isEmpty() ?
         String.format("%s, %s", lastName, firstName) :
         String.format("%s, %s %s", lastName, firstName, middleInitials);
   }

   private static String extractInitial(String name) {
      return name.charAt(0) + ".";
   }
}
