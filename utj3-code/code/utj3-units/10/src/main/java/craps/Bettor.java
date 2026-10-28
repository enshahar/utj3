/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package craps;

public class Bettor {
   private BettorState state = new InitialState();
   private int point;
   private String indent = "";

   public BettorState state() {
      return state;
   }

   void throwDice() {
      state.throwDice(this);
   }

   public void record(Roll roll) {
      System.out.println(indent + "rolled " + roll.total());
   }

   public void crapsOut() {
      System.out.println("crapped out!");
      System.out.println();
      resetIndent();

      state = new NextBettorState();
   }

   public void wins() {
      System.out.println("won!");
      System.out.println();
      resetIndent();

      state = new InitialState();
   }

   private void resetIndent() {
      indent = "";
   }

   public void establishPoint(int rollTotal) {
      System.out.println("point of " + rollTotal + " established");

      state = new PointEstablishedState();
      indent = "\t";
      point = rollTotal;
   }

   public int point() {
      return point;
   }

   public boolean isTurnOver() {
      return state().getClass() == NextBettorState.class;
   }
}
