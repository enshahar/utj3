/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package app;

import java.time.Clock;
import static app.TransactionType.BUY;
import static app.TransactionType.SELL;
import static java.lang.Math.abs;
import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Transaction lastTransaction;
    private Clock clock = Clock.systemUTC();
    private Map<String, Integer> purchases = new HashMap<>();

    public boolean isEmpty() {
        return purchases.isEmpty();
    }

    public void purchase(String symbol, int shares) {
        updateShares(symbol, shares, BUY);
    }

    public void sell(String symbol, int shares) {
        abortOnOversell(symbol, shares);
        updateShares(symbol, -shares, SELL);
        removeSymbolIfSoldOut(symbol);
    }

    private void updateShares(String symbol, int shares, TransactionType type) {
        lastTransaction =
            new Transaction(symbol, abs(shares), type, clock.instant());
        purchases.put(symbol, sharesOf(symbol) + shares);
    }
    private void removeSymbolIfSoldOut(String symbol) {
        if (sharesOf(symbol) == 0)
            purchases.remove(symbol);
    }

    private void abortOnOversell(String symbol, int shares) {
        if (sharesOf(symbol) < shares)
            throw new InvalidTransactionException();
    }

    public int size() {
        return purchases.size();
    }

    public int sharesOf(String symbol) {
        return purchases.getOrDefault(symbol, 0);
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

    public Transaction lastTransaction() {
        return lastTransaction;
    }
}
