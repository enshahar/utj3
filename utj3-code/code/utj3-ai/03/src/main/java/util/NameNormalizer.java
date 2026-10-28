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

   public String normalizeName(String name) {
      var nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      return formatLastNameFirst(
         firstName(nameParts),
         lastName(nameParts),
         middleNames(nameParts));
   }

   private String firstName(String[] nameParts) {
      return nameParts[0];
   }

   private String lastName(String[] nameParts) {
      return nameParts[nameParts.length - 1];
   }

   private String[] middleNames(String[] nameParts) {
      return Arrays.copyOfRange(
         nameParts, 1, nameParts.length - 1);
   }

   private String formatLastNameFirst(
      String firstName, String lastName, String[] middleNames) {
      var middleInitials = Arrays.stream(middleNames)
         .map(this::extractInitial)
         .collect(Collectors.joining(" "));

      return middleInitials.isEmpty() ?
         String.format("%s, %s", lastName, firstName) :
         String.format("%s, %s %s", lastName, firstName, middleInitials);
   }

   private String extractInitial(String name) {
      return name.charAt(0) + ".";
   }
}
