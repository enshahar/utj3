/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package cards;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
   private LinkedList<Card> cards;

   public Deck() {
      cards = newDeck();
      Collections.shuffle(cards);
   }

   static LinkedList<Card> newDeck() {
      var cards = new LinkedList<Card>();
      for (var i = 1; i <= 13; i++) {
         cards.add(new Card(i, "C"));
         cards.add(new Card(i, "D"));
         cards.add(new Card(i, "H"));
         cards.add(new Card(i, "S"));
      }
      return cards;
   }

   public Card deal() {
      return cards.removeFirst();
   }

   List<Card> remaining() {
      return cards;
   }
}
