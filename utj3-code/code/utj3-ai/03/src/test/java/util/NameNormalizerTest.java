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

   private final NameNormalizer normalizer = new NameNormalizer();

   @Test
   public void singleName() {
      assertEquals("Plato", normalizer.normalizeName("Plato"));
   }

   @Test
   public void firstNameLastName() {
      assertEquals("Cohen, Leonard", normalizer.normalizeName("Leonard Cohen"));
   }

   @Test
   public void multipleMiddleNames() {
      assertEquals("Jackson, Samuel L.", normalizer.normalizeName("Samuel Leroy Jackson"));
      assertEquals("Martin, George R. R.", normalizer.normalizeName("George Raymond Richard Martin"));
   }

   @Test
   public void longName() {
      assertEquals("Hackley, Emma A. S.", normalizer.normalizeName("Emma Azalia Smith Hackley"));
   }
}
