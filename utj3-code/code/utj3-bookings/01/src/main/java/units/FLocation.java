/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

public record FLocation(int x, int y, FLocation.Heading heading) {
   enum Heading {
      North {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x, location.y + distance, North);
         }
      },
      East {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x + distance, location.y, East);
         }
      },
      South {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x, location.y - distance, South);
         }
      },
      West {
         @Override public FLocation move(FLocation location, int distance) {
            return new FLocation(location.x - distance, location.y, West);
         }
      };
      public abstract FLocation move(FLocation location, int distance);
   }

   FLocation move(int distance) {
      return heading.move(this, distance);
   }
}
