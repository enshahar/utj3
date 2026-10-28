/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ARomanNumberConverter {
   RomanNumberConverter converter = new RomanNumberConverter();

   @Test
   void convertsOne() {
      assertEquals("I", converter.toRoman(1));
   }

   @Test
   void convertsTwo() {
      assertEquals("II", converter.toRoman(2));
   }

   @Test
   void convertsThree() {
      assertEquals("III", converter.toRoman(3));
   }

   // ... so wordy!

   @ParameterizedTest
   @CsvSource({
      "1,    I",
      "2,    II",
      "3,    III",
      "10,   X",
      "20,   XX",
      "11,   XI",
      "200,  CC",
      "732,  DCCXXXII",
      "2275, MMCCLXXV",
      "999,  CMXCIX",
      "444,  CDXLIVI", // failure
   })
   void convertAll(int arabic, String roman) {
      assertEquals(roman, converter.toRoman(arabic));
   }
}
