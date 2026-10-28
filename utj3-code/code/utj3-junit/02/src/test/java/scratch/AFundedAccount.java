/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import org.junit.jupiter.api.*;

class AFundedAccount {
   Account account = new Account("Jeff");
   AFundedAccount() {
      System.out.printf("AFundedAccount(); %s balance = %d%n", account.name, account.balance);
   }

   @BeforeEach
   void fundAccount() {
      System.out.println("\t\t@BeforeEach::fundAccount");
      account.deposit(1000);
   }

   @BeforeAll
   static void clearAccountRegistry() {
      System.out.println("@BeforeAll::clearAccountRegistry");
      // ...
   }

   @Nested
   class AccruingInterest {
      {
         System.out.println("\tAccruing Interest");
      }

      @BeforeEach
      void setInterestRate() {
         System.out.println("\t\t@BeforeEach::setInterestRate");
         account.setInterestRate(0.027d);
      }

      @Test
      void occursWhenMinimumMet() {
         System.out.println("\t\toccursWhenMinimumMet");
         // ...
      }

      @Test
      void doesNotOccurWhenMinimumNotMet() {
         System.out.println("\t\tdoesNotOccurWhenMinimumNotMet");
         // ...
      }

      @Test
      void isReconciledWithMasterAccount() {
         System.out.println("\t\taccruesNoInterestWhenMinimumMet");
         // ...
      }
   }

   @Nested
   class Withdrawal {
      {
         System.out.println("\tWithdrawal");
      }

      @Test
      void reducesAccountBalance() {
         System.out.println("\t\treducesAccountBalance");
         // ...
      }

      @Test
      void throwsWhenAmountExceedsBalance() {
         System.out.println("\t\tthrowsWhenAmountExceedsBalance");
         // ...
      }

      @Test
      void notifiesIRSWhenAmountExceedsThreshold() {
         System.out.println("\t\tnotifiesIRSWhenAmountExceedsThreshold");
         // ...
      }
   }
}
