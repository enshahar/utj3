/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package craps;

import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
   public static final int DIE_SIDES = 6;

   private static final Dice instance = new Dice();
   public static final Dice get() {
      return instance;
   }

   private Random random = new Random();

   public Roll roll(int numberOfDice) {
      var dieRolls = IntStream.range(0, numberOfDice)
         .map(n -> random.nextInt(DIE_SIDES) + 1)
         .toArray();
      return new Roll(dieRolls);
   }
}
