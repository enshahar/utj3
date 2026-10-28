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

import static units.FixedLocation.*;

public class DestinationList {
   private List<FixedLocation> locations = new ArrayList<>();

   public void add(FixedLocation location) {
      if (locations.contains(location))
         return;
      locations.add(location);
   }

   public void moveLocationsWithHeading(Heading heading, int x, int y) {
      this.locations = locations.stream()
         .map(location -> location.heading().equals(heading)
            ? new FixedLocation(x, y, heading)
            : location)
         .toList();
   }

   public void removeLocationsFurtherThan(int x, int y, int distance) {
      this.locations = locations.stream()
         .filter(location -> location.distanceFrom(x, y) < distance)
         .toList();
   }

   public List<FixedLocation> getLocations() {
      return locations;
   }
}
