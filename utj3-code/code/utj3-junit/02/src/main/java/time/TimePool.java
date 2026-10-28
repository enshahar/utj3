/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package time;

import java.util.HashMap;
import java.util.Map;

public class TimePool {
   private static Map<String, Time> times = new HashMap<>();

   static void reset() {
      times.clear();
   }

   public static Time get(byte hour, byte minute) {
      return times.computeIfAbsent(Time.key(hour, minute),
         k -> new Time(hour, minute));
   }
}
