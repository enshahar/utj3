/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package com.langrsoft.util;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("slow")
class AnHttpImpl {
    static final String GET_ECHO =
        "http://httpbin.org/response-headers?Content-Type=text/plain&custom=%s";

    @Test
    void retrieves() {
        var result = new HttpImpl().get(GET_ECHO.formatted("hello,%20Jeff!"));
        assertTrue(result.contains("hello, Jeff!"));
    }
}
