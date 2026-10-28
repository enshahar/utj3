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
import java.util.List;
import static app.TransactionType.BUY;
import static app.TransactionType.SELL;
import static java.lang.Math.abs;

public class Portfolio {
    private TransactionHistory history = new TransactionHistory();
    private Clock clock = Clock.systemUTC();

    public void purchase(String symbol, int shares) {
        updateShares(symbol, shares, BUY);
    }

    public void sell(String symbol, int shares) {
        abortOnOversell(symbol, shares);
        updateShares(symbol, -shares, SELL);
    }

    private void abortOnOversell(String symbol, int shares) {
        if (sharesOf(symbol) < shares)
            throw new InvalidTransactionException();
    }

    private void updateShares(String symbol,
                              int shares,
                              TransactionType type) {
        var transaction =
            new Transaction(symbol, abs(shares), type, clock.instant());
        history.add(transaction);
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public Transaction lastTransaction() {
        return history.lastTransaction();
    }

    public List<Transaction> transactions() {
        return history.transactions();
    }

    public int size() {
        return history.size();
    }

    public int sharesOf(String symbol) {
        return history.sharesOf(symbol);
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
