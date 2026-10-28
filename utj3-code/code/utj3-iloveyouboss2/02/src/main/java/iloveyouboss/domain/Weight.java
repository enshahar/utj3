/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

public enum Weight {
   REQUIRED(0),
   VERY_IMPORTANT(5000),
   IMPORTANT(1000),
   WOULD_PREFER(100),
   DONT_CARE(1);
   
   private final int value;

   Weight(int value) { this.value = value; }
   public int getValue() { return value; }
}
