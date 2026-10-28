/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ADeck {
   Deck deck = new Deck();

   @Test
   void newDeckContainsAll52Cards() {
      var cards = Deck.newDeck();

      assertEquals(List.of(
            "AC", "AD", "AH", "AS", "2C", "2D", "2H", "2S",
            "3C", "3D", "3H", "3S", "4C", "4D", "4H", "4S",
            "5C", "5D", "5H", "5S", "6C", "6D", "6H", "6S",
            "7C", "7D", "7H", "7S", "8C", "8D", "8H", "8S",
            "9C", "9D", "9H", "9S", "10C", "10D", "10H", "10S",
            "JC", "JD", "JH", "JS", "QC", "QD", "QH", "QS",
            "KC", "KD", "KH", "KS"),
         cards.stream().map(Card::toString).toList());
   }

   @Test
   void containsAllCards() {
      var cards = deck.remaining();

      assertEquals(Deck.newDeck(), sort(cards));
   }

   @Nested
   class Deal {
      Card dealt;
      Card firstFromDeck;

      @BeforeEach
      void dealCard() {
         firstFromDeck = deck.remaining().get(0);
         dealt = deck.deal();
      }

      @Test
      void returnsFirstCardFromDeck() {
         assertEquals(firstFromDeck, dealt);
      }

      @Test
      void removesDealtCardFromDeck() {
         assertEquals(51, deck.remaining().size());
         assertFalse(deck.remaining().contains(dealt));
      }
   }

   // ... other Deck tests here ...

   @Test
   void hasBeenShuffled() {
      var cards = deck.remaining();

      assertNotEquals(Deck.newDeck(), cards);
   }

   private <T> List<T> sort(List<T> list) {
      return list.stream().sorted().toList();
   }
}
