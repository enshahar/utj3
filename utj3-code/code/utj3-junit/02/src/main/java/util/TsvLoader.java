/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;


import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;

public class TsvLoader {
   public List<List<String>> loadFrom(BufferedReader reader) {
      return reader.lines()
         .map(row -> row.split("\t"))
         .map(Arrays::asList)
         .toList();
   }
}
