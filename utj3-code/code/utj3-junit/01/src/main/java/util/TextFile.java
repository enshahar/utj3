/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public record TextFile(String name, String content) {
   public void write() {
      try (var writer = new BufferedWriter(new FileWriter(name))) {
         writer.write(content);
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
