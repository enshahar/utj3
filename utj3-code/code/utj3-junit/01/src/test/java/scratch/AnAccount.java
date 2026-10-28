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
import util.ExpectToFail;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
// ...


class AnAccount {
   Account account;

   @BeforeEach
   void createAccount() {
      account = new Account("an account name");
   }
   // ...

   @Nested class SomeDifferentScope {
   @Test
   void hasPositiveBalanceAfterInitialDeposit() {
      var account = new Account("an account name");

      account.deposit(50);

      Assertions.assertTrue(account.hasPositiveBalance());
   }
   // ...
   }

   @Test
   void doesNotHavePositiveBalanceWhenAccountCreated() {
      assertTrue(!account.hasPositiveBalance());
      assertFalse(account.hasPositiveBalance());
   }

   @Test
   void hasPositiveBalanceAfterInitialDeposit() {
      var account = new Account("an account name");

      account.deposit(50);

      assertTrue(account.hasPositiveBalance());
   }

   @Test
   void depositIncreasesBalance() {
      var account = new Account("an account name");
      var initialBalance = account.getBalance();

      account.deposit(100);

      assertTrue(account.getBalance() > initialBalance);
   }

   @Test
   void depositIncreasesBalanceByAmountDeposited() {
      account.deposit(50);

      account.deposit(100);

      assertEquals(150, account.getBalance());
   }

   @Nested
   class SillyAssertMessage {
      @BeforeEach
      void setUpBadState() {
         account.deposit(1);
      }

      @ExpectToFail
      @Disabled
      @Test
      void balanceRepresentsTotalOfDeposits() {
         account.deposit(50);
         account.deposit(51);

         var balance = account.getBalance();

         assertEquals(101, balance, "account balance must be total of deposits");
      }
   }

   @Test
   @ExpectToFail
   @Disabled
   void assertFailure() {
      assertTrue(account.getName().startsWith("xyz"));
   }

   @Test
   @ExpectToFail
   @Disabled
   void equals() {
      var account = new Account("acct namex");
      assertEquals("acct name", account.getName());
   }

   @Nested
   class TryCatchExceptions {
      @Test
      void throwsWhenWithdrawingTooMuch() {
         try {
            account.withdraw(100);
            fail();
         } catch (InsufficientFundsException expected) {
            assertEquals("balance only 0", expected.getMessage());
         }
      }
   }

   @Nested
   class NewSchoolExceptions {
      @Test
      void throwsWhenWithdrawingTooMuch() {
         var thrown = assertThrows(InsufficientFundsException.class,
            () -> account.withdraw(100));
         assertEquals("balance only 0", thrown.getMessage());
      }
   }

}
