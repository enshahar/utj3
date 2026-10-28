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

public class RomanNumberConverter {
   record Digit(int arabic, String roman) {}

   Digit[] conversions = {
      new Digit(1000, "M"),
      new Digit(900, "CM"),
      new Digit(500, "D"),
      new Digit(400, "CD"),
      new Digit(100, "C"),
      new Digit(90, "XC"),
      new Digit(50, "L"),
      new Digit(40, "XL"),
      new Digit(10, "X"),
      new Digit(9, "IX"),
      new Digit(5, "V"),
      new Digit(4, "IV"),
      new Digit(1, "I")
   };

   public String toRoman(int arabic) {
      return Arrays.stream(conversions).reduce(
         new Digit(arabic, ""),
         (acc, conversion) -> {
            var digitsRequired = acc.arabic / conversion.arabic;
            return new Digit(
               acc.arabic - digitsRequired * conversion.arabic,
               acc.roman + conversion.roman.repeat(digitsRequired));
         }).roman();
   }
}
