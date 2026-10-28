/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeAssertExamples {
   @Test
   void readsFromTestFile() throws IOException {
      var writer = new BufferedWriter(new FileWriter("test.txt"));
      writer.write("test data");
      writer.close();
      // ...
   }

   @AfterEach
   void deleteForReadsFromTestFile() {
      new File("test.txt").delete();
   }

   @Test
   @Disabled("don't forget me!")
   void somethingWeCannotHandleRightNow() {
      // ...
   }

   @Test
   void doubles() {
      assertEquals(9.7, 10.0 - 0.3, 0.005);
   }
}
