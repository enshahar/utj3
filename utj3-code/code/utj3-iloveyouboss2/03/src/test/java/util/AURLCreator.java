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
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.net.MalformedURLException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AURLCreator {
   URLCreator urlCreator = new URLCreator();

   @Test
   void returnsCombinedURLStringGivenServerAndDocument()
         throws MalformedURLException {
      assertEquals(
         "https://example.com/customer?id=123",
         urlCreator.create("example.com", "customer?id=123"));
   }

   @ParameterizedTest
   @NullSource
   @ValueSource(strings = { "", " \n\t\r " })
   void buildsURLGivenServerOnly(String document)
         throws MalformedURLException {
      assertEquals(
         "https://example.com",
         urlCreator.create("example.com", document));
   }

   @Test
   void eliminatesRedundantLeadingSlash() throws MalformedURLException {
      assertEquals(
         "https://example.com/customer?id=123",
         urlCreator.create("example.com", "/customer?id=123"));
   }
}
