/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

public record FixedLocation(int x, int y, Heading heading) {
   public FixedLocation move(int distance) {
      return switch (heading) {
         case North -> new FixedLocation(x, y + distance, heading);
         case East -> new FixedLocation(x + distance, y, heading);
         case South -> new FixedLocation(x, y - distance, heading);
         case West -> new FixedLocation(x - distance, y, heading);
      };
   }
}
