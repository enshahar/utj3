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

   // Define a record to hold extracted name parts and suffix
   private record ExtractedNameParts(String[] nameParts, String suffix) {}

   public String normalizeName(String name) {
      var extractedNameParts = extractSuffix(name);
      this.nameParts = extractedNameParts.nameParts();
      this.suffix = extractedNameParts.suffix();

      if (nameParts.length == 1) {
         return nameParts[0] + suffix;
      }

      return formatLastNameFirst() + suffix;
   }

   private ExtractedNameParts extractSuffix(String name) {
      if (name.contains(",")) {
         var parts = name.split(", ", 2);
         return new ExtractedNameParts(parts[0].split(" "), ", " + parts[1]);
      } else {
         return new ExtractedNameParts(name.split(" "), "");
      }
   }

   private String formatLastNameFirst() {
      return lastName() + ", " + firstName() + middleInitialsString();
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
