/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package portfolio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ANonEmptyPortfolio {
    Portfolio portfolio = new Portfolio();
    int initialSize;

    @BeforeEach
    void purchaseASymbol() {
        portfolio.purchase("LSFT", 20);
        initialSize = portfolio.size();
    }

    @Nested
    class WhenPurchasingAnotherSymbol {
        @BeforeEach
        void purchaseAnotherSymbol() {
            portfolio.purchase("AAPL", 10);
        }

        @Test
        void increasesSize() {
            assertEquals(initialSize + 1, portfolio.size());
        }
    }
}
