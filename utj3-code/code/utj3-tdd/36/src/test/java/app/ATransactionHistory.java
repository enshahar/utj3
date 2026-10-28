/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package app;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static app.TransactionType.BUY;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ATransactionHistory {
    TransactionHistory history = new TransactionHistory();
    Instant now = Instant.now();

    @Test
    void returnsTransactionsForSymbol() {
        history.add(new Transaction("A", 10, BUY, now));
        history.add(new Transaction("B", 20, BUY, now));
        history.add(new Transaction("B", 30, BUY, now));

        var results = history.transactionStreamBySymbol("B");

        assertEquals(results.toList(), List.of(
            new Transaction("B", 30, BUY, now),
            new Transaction("B", 20, BUY, now)));
    }

    @Test
    void returnsSharesOfSymbol() {
        history.add(new Transaction("A", 10, BUY, now));
        history.add(new Transaction("B", 20, BUY, now));
        history.add(new Transaction("B", 30, BUY, now));

        assertEquals(50, history.sharesOf("B"));
    }

    @Test
    void returnsZeroSharesForNonexistentSymbol() {
        assertEquals(0, history.sharesOf("C"));
    }
}
