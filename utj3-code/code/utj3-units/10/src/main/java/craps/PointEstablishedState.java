/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package craps;

public class PointEstablishedState extends BettorState {
   @Override
   public void resolve(Bettor bettor, Roll roll) {
      if (roll.total() == 7)
         bettor.crapsOut();
      if (roll.total() == bettor.point())
         bettor.wins();
   }
}
