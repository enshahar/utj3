/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class AnUnfundedAccount {
   @Disabled
   @Test
   void disallowsWithdrawals() {
      // ...
   }

   @Test
   void doesNotAccrueInterest() {
      // ... 어, 이 테스트에 집중해야겠네요
   }
}
