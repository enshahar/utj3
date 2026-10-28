/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

public class Batter {
   private int strikeCount = 0;
   private int ballCount = 0;

   public void foul() {
      if (strikeCount < 2)
         strikeCount++;
   }

   public void ball() {
      ballCount++;
   }

   public void strike() {
      strikeCount++;
   }

   public int strikeCount() {
      return strikeCount;
   }

   public boolean isDone() {
      return struckOut() || walked();
   }

   private boolean walked() {
      return ballCount == 4;
   }

   private boolean struckOut() {
      return strikeCount == 3;
   }
}
