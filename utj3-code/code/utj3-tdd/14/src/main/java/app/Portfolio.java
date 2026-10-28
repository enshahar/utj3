/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package app;

import java.util.HashSet;
import java.util.Set;

public class Portfolio {
    private int size = 0;
    private Set symbols = new HashSet<String>();

    public boolean isEmpty() {
        return symbols.isEmpty();
    }

    public void purchase(String symbol, int shares) {
        size++;
        symbols.add(symbol);
    }

    public int size() {
        return symbols.size();
    }
}
