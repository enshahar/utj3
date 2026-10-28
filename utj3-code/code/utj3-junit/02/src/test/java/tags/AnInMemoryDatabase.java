/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AnInMemoryDatabase {
   // ...
   @Tag("v11.1_defects")
   @Test
   void objectCopiedWhenAddedToDatabaseFailing() {
      // ...
   }
   // ...
}
