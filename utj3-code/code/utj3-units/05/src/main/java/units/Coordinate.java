/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

public record Coordinate(int x, int y) {
   public Coordinate move(int distance, Heading heading) {
      return switch (heading) {
         case North -> new Coordinate(x, y + distance);
         case East -> new Coordinate(x + distance, y);
         case South -> new Coordinate(x, y - distance);
         case West -> new Coordinate(x - distance, y);
      };
   }
}
