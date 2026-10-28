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
    private Set symbols = new HashSet<String>();
    private int shares;

    public boolean isEmpty() {
        return symbols.isEmpty();
    }

    public void purchase(String symbol, int shares) {
        symbols.add(symbol);
        this.shares = shares;
    }

    public int size() {
        return symbols.size();
    }

    public int sharesOf(String symbol) {
        return shares;
    }
}
