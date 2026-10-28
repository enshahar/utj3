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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NameNormalizerTest {

   @Test
   public void testSingleName() {
      assertEquals("Plato",
         NameNormalizer.normalizeName("Plato"));
   }

   @Test
   public void testFirstNameLastName() {
      assertEquals("Cohen, Leonard",
         NameNormalizer.normalizeName("Leonard Cohen"));
   }

   @Test
   public void testMultipleMiddleNames() {
      assertEquals("Jackson, Samuel L.",
         NameNormalizer.normalizeName("Samuel Leroy Jackson"));
      assertEquals("Martin, George R. R.",
         NameNormalizer.normalizeName("George Raymond Richard Martin"));
   }

   @Test
   public void testLongName() {
      assertEquals("Hackley, Emma A. S.",
         NameNormalizer.normalizeName("Emma Azalia Smith Hackley"));
   }
}
