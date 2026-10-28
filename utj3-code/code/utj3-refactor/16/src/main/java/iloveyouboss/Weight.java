/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

public enum Weight {
    REQUIRED(Integer.MAX_VALUE),
    VERY_IMPORTANT(5000),
    IMPORTANT(1000),
    NICE_TO_HAVE(100),
    IRRELEVANT(0);

    private final int value;

    Weight(int value) { this.value = value; }
    public int value() { return value; }
}
