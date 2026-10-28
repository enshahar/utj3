/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package persistence;

import org.junit.jupiter.api.Nested;
import util.ExpectToFail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnInMemoryDatabase {
   @Test
   void objectCopiedWhenAddedToDatabase() {
      var db = new InMemoryDatabase();
      var customer = new Customer("1", "Smelt, Inc.");

      db.add(customer);

      var retrieved = db.data.get("1");
      assertNotSame(retrieved, customer);
   }

   @ExpectToFail
   @Test
   void objectCopiedWhenAddedToDatabaseFailing() {
      var db = new InMemoryDatabase();
      var customer = new Customer("1", "Smelt, Inc.");

      db.addBad(customer);

      var retrieved = db.data.get("1");
      assertNotSame(retrieved, customer);
   }

   InMemoryDatabase db = new InMemoryDatabase();

   @Test
   void returnsCustomerCorrespondingToId() {
      var customer = new Customer("42", "Mr Creosote");
      db.add(customer);

      var retrieved = db.get("42");

      assertEquals(customer, retrieved);
   }

   @Test
   void returnsNotNullForNonexistentKey() {
      assertNull(db.get("42"));
   }

   @Nested
   class Silliness {
      @Test
      void returnsCustomerCorrespondingToId() {
         var customer = new Customer("42", "Mr Creosote");
         assertNotNull(customer); // bogus! this can't fail
         db.add(customer);

         var retrieved = db.get("42");

         assertEquals(customer, retrieved);
      }
   }
}
