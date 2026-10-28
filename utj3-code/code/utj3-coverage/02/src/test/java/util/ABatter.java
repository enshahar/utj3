/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ABatter {
   Batter batter = new Batter();

   @Nested
   class IsDone {
      @Test
      void whenStruckOut() {
         batter.strike();
         batter.strike();
         batter.strike();

         assertTrue(batter.isDone());
      }
   }

   @Nested
   class AStrike {
      @Test
      void incrementsStrikes() {
         batter.strike();

         assertEquals(1, batter.strikeCount());
      }
   }

   @Nested
   class AFoulBall {
      @Test
      void incrementsStrikesWhenLessThan2() {
         batter.strike();

         batter.foul();

         assertEquals(2, batter.strikeCount());
      }

      @Test
      void doesNotIncrementStrikesWhenAtTwo() {
         batter.strike();
         batter.strike();

         batter.foul();

         assertEquals(2, batter.strikeCount());
      }
   }
}
