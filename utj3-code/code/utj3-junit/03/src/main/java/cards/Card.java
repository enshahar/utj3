/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package cards;

import static java.lang.Integer.compare;

public record Card(int rank, String suit) implements Comparable<Card> {
   private String rankName() {
      return switch (rank) {
         case 1 -> "A";
         case 11 -> "J";
         case 12 -> "Q";
         case 13 -> "K";
         default -> String.valueOf(rank);
      };
   }

   public String toString() {
      return rankName() + suit();
   }

   @Override
   public int compareTo(Card that) {
      var rankCompare = compare(this.rank(), that.rank());
      return rankCompare != 0 ? rankCompare : this.suit().compareTo(that.suit());
   }
}
