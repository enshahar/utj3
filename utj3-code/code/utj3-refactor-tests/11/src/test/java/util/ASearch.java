/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

// text courtesy of Herman Melville (Moby Dick) from
// http://www.gutenberg.org/cache/epub/2701/pg2701.txt 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class ASearch {
   static final String A_TITLE = "1";

   @BeforeEach
   void suppressLogging() {
      Search.LOGGER.setLevel(Level.OFF);
   }

   @Test
   void returnsMatchesWithSurroundingContext() {
      var stream = streamOn("""
         rest of text here
         1234567890search term1234567890
         more rest of text""");
      var search = new Search(stream, "search term", A_TITLE);
      search.setSurroundingCharacterCount(10);

      search.execute();

      var matches = search.getMatches();
      assertEquals(List.of(
              new Match(A_TITLE,
                  "search term",
                  "1234567890search term1234567890")),
          matches);
   }

   @Test
   void returnsNoMatchesWhenSearchTextNotFound() {
      var stream = streamOn("text that ain't gonna match");
      var search = new Search(stream, "missing search term", A_TITLE);

      search.execute();

      assertTrue(search.getMatches().isEmpty());
   }

   @Test
   void erroredReturnsFalseWhenReadSucceeds() {
      var stream = streamOn("");
      var search = new Search(stream, "", "");

      search.execute();

      assertFalse(search.errored());
   }

   @Test
   public void erroredReturnsTrueWhenUnableToReadStream() {
      var stream = createStreamThrowingErrorWhenRead();
      var search = new Search(stream, "", "");

      search.execute();

      assertTrue(search.errored());
   }

   private InputStream createStreamThrowingErrorWhenRead() {
      return new InputStream() {
         @Override
         public int read() throws IOException { throw new IOException(); }
      };
   }

   private static ByteArrayInputStream streamOn(String text) {
       return new ByteArrayInputStream(text.getBytes());
   }
}
