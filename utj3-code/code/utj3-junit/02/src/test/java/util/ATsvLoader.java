/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.junit.jupiter.api.Assertions.*;

class ATsvLoader {
   private TsvLoader loader;

   @BeforeEach void createLoader() {
      loader = new TsvLoader();
   }

   @Test
   public void loadsSingleColumnSingleRow() {
      assertEquals(
         List.of(List.of("abc")),
         loader.loadFrom(bufferedReaderOn("abc")));
   }

   @Test
   public void loadsMultipleColumnsSingleRow() {
      assertEquals(
         List.of(List.of("abc", "def")),
         loader.loadFrom(bufferedReaderOn("abc\tdef")));
   }

   @Test
   public void loadsMultipleColumnsMultipleRows() {
      assertEquals(
         List.of(List.of("abc", "def"), List.of("uvw", "xyz")),
         loader.loadFrom(bufferedReaderOn("abc\tdef\nuvw\txyz")));
   }

   private BufferedReader bufferedReaderOn(String... lines) {
      return new BufferedReader(
         new InputStreamReader(
            new ByteArrayInputStream(withEOLs(lines).getBytes())));
   }

   private String withEOLs(String... lines) {
      return Arrays.stream(lines)
         .map(line -> line + System.lineSeparator())
         .collect(joining());
   }
}
