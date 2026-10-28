/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package units.validations;

import units.Booking;
import units.Validation;

public class AgeMinimum implements Validation {
   private final Booking booking;

   public AgeMinimum(Booking booking) {
      this.booking = booking;
   }

   @Override
   public boolean isInvalid() {
      return booking.age() < 18;
   }

   @Override
   public String errorMessage() {
      return "Minor cannot fly unaccompanied";
   }
}
