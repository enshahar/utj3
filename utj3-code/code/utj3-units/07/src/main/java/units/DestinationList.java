/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units;

import java.util.ArrayList;
import java.util.List;

public class DestinationList {
   private List<FixedLocation> locations = new ArrayList<>();

   public void add(FixedLocation location) {
      locations.add(location);
   }

   public List<FixedLocation> getLocations() {
      return locations;
   }
}
