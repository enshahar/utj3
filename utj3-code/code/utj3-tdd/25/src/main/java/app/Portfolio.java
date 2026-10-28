/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package app;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> purchases = new HashMap<>();

    public boolean isEmpty() {
        return purchases.isEmpty();
    }

    public void purchase(String symbol, int shares) {
        purchases.put(symbol, sharesOf(symbol) + shares);
    }

    public int size() {
        return purchases.size();
    }

    public int sharesOf(String symbol) {
        return purchases.getOrDefault(symbol, 0);
    }
}
