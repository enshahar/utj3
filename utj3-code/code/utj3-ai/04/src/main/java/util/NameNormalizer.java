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

   public String normalizeName(String name) {
      this.nameParts = name.split(" ");
      if (nameParts.length == 1) {
         return name;
      }

      return formatLastNameFirst();
   }
   // ...

   private String firstName() {
      return nameParts[0];
   }

   private String lastName() {
      return nameParts[nameParts.length - 1];
   }

   private String[] middleNames() {
      return Arrays.copyOfRange(nameParts, 1, nameParts.length - 1);
   }

   private String formatLastNameFirst() {
      var middleInitials = Arrays.stream(middleNames())
         .map(this::initial)
         .collect(Collectors.joining(" "));
      return middleInitials.isEmpty() ?
         String.format("%s, %s", lastName(), firstName()) :
         String.format("%s, %s %s", lastName(), firstName(), middleInitials);
   }

   private String initial(String name) {
      return name.charAt(0) + ".";
   }
}
