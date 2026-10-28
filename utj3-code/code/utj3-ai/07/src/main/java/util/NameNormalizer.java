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

   private String[] nameParts;
   private String suffix = "";

   public String normalizeName(String name) {
      extractSuffix(name);
      // Handle case for 1 name w/ no middle names but possible a suffix
      if (nameParts.length == 1) {
         return nameParts[0] + suffix;
      }

      return formatLastNameFirst() + suffix;
   }

   private void extractSuffix(String name) {
      if (name.contains(",")) {
         var parts = name.split(", ", 2);
         this.nameParts = parts[0].split(" ");
         this.suffix = ", " + parts[1];
      } else {
         this.nameParts = name.split(" ");
      }
   }

   private String formatLastNameFirst() {
      var firstName = firstName();
      var lastName = lastName();
      var middleInitials = middleInitialsString();

      return String.format("%s, %s%s", lastName, firstName, middleInitials);
   }

   private String firstName() {
      return nameParts[0];
   }

   private String lastName() {
      return nameParts[nameParts.length - 1];
   }

   private String middleInitialsString() {
      if (nameParts.length > 2) {
         return " " + Arrays.stream(middleNames())
            .map(this::initial)
            .collect(Collectors.joining(" "));
      }
      return "";
   }

   private String[] middleNames() {
      if (nameParts.length > 2) {
         return Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);
      }
      return new String[]{};
   }

   private String initial(String name) {
      return name.charAt(0) + ".";
   }
}
