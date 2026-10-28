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

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class ASearch {
   static final String A_TITLE = "1";
   @Test
   void returnsMatchesWithSurroundingContext() throws IOException {
      var stream = streamOn("There are certain queer times and occasions "
          // ...
          + "in this strange mixed affair we call life when a man "
          + "takes this whole universe for a vast practical joke, "
          + "though the wit thereof he but dimly discerns, and more "
          + "than suspects that the joke is at nobody's expense but his own.");
      var search = new Search(stream, "practical joke", A_TITLE);
      Search.LOGGER.setLevel(Level.OFF);
      search.setSurroundingCharacterCount(10);
      search.execute();
      assertFalse(search.errored());
      var matches = search.getMatches();
      assertEquals(List.of(
              new Match(A_TITLE,
                  "practical joke",
                  "or a vast practical joke, though t")),
          matches);
      stream.close(); // delete me
   }

   @Test
   void returnsNoMatchesWhenSearchTextNotFound() throws IOException {
      var connection =
         new URL("http://bit.ly/15sYPA7").openConnection();
      var inputStream = connection.getInputStream();
      var search = new Search(inputStream, "smelt", A_TITLE);
      search.execute();
      assertTrue(search.getMatches().isEmpty());
      inputStream.close();
   }
   private static ByteArrayInputStream streamOn(String text) {
       return new ByteArrayInputStream(text.getBytes());
   }
}
