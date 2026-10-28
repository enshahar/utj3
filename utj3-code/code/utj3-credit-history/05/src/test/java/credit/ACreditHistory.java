/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package credit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ACreditHistory {
   @Test
   void withNoCreditRatingsHas0Mean() {
      var creditHistory = new CreditHistory();
      var result = creditHistory.arithmeticMean();
      assertEquals(0, result);
   }

   @Test
   void withOneRatingHasEquivalentMean() {
      var creditHistory = new CreditHistory();
      creditHistory.add(new CreditRating(780));
      var result = creditHistory.arithmeticMean();
      assertEquals(780, result);
   }
}
