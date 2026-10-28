/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATextFile {
   private static File file;

   @BeforeAll
   static void createFile() throws IOException {
      file = File.createTempFile("ATextFile", "test.txt");
   }

   @Test
   void writesContentToFile() throws IOException {
      var filename = "ATextFile.test.txt";
      var textFile = new TextFile(filename, "some content");

      textFile.write();

      assertEquals("some content", contentsAsString(filename));
   }

   private static String contentsAsString(String filename) throws IOException {
      var scanner = new Scanner(new File(filename));
      scanner.useDelimiter("\\Z");
      return scanner.next();
   }
}