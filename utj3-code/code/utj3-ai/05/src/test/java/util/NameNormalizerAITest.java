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

public class NameNormalizerAITest {
   private NameNormalizer normalizer = new NameNormalizer();

   @Test
   public void testSimpleTwoPartName() {
      assertEquals("Doe, John", normalizer.normalizeName("John Doe"));
   }

   @Test
   public void testNameWithMiddleInitial() {
      assertEquals("Doe, John A.",
          normalizer.normalizeName("John A. Doe"));
   }

   @Test
   public void testNameWithSuffix() {
      assertEquals("Doe, John Jr.",
          normalizer.normalizeName("John Doe, Jr."));
   }

   @Test
   public void testSingleName() {
      assertEquals("John", normalizer.normalizeName("John"));
   }

   @Test
   public void testNameWithMiddleNames() {
      assertEquals("Doe, John A. B.",
          normalizer.normalizeName("John Adam Bernard Doe"));
   }

   @Test
   public void testEmptyString() {
      assertEquals("", normalizer.normalizeName(""));
   }

   // Optional: If handling null is expected
   @Test
   public void testNullInput() {
      assertEquals(null, normalizer.normalizeName(null));
   }
}
