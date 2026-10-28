/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

public class Account {
   int balance;
   String name;

   Account(String name) {
      this.name = name;
   }

   void deposit(int dollars) {
      balance += dollars;
   }

   void withdraw(int dollars) {
      if (balance < dollars) {
         throw new InsufficientFundsException("잔액이 " + balance + " 원뿐이다");
      }
      balance -= dollars;
   }

   public String getName() {
      return name;
   }

   public int getBalance() {
      return balance;
   }

   public boolean hasPositiveBalance() {
      return balance > 0;
   }

   public void setInterestRate(double rate) {
   }
}
