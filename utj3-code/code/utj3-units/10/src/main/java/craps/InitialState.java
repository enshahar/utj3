/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package craps;

import java.util.List;

public class InitialState extends BettorState {
   private static final List<Integer> craps = List.of(2, 3, 12);
   private static final List<Integer> winningRolls = List.of(7, 11);

   @Override
   public void resolve(Bettor bettor, Roll roll) {
      if (craps.contains(roll.total()))
         bettor.crapsOut();
      else if (winningRolls.contains(roll.total()))
         bettor.wins();
      else
         bettor.establishPoint(roll.total());
   }
}
