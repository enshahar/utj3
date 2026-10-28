/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class TimestampSource {
    private static final LinkedList<LocalDateTime> storedTimes = new LinkedList<>();

    public static void queueNextTime(LocalDateTime timestamp) {
        storedTimes.add(timestamp);
    }

    public static LocalDateTime now() {
        if (storedTimes.isEmpty())
            return LocalDateTime.now();
        return storedTimes.removeFirst();
    }

    public static boolean isExhausted() {
        return storedTimes.isEmpty();
    }

    public static void emptyQueue() {
        storedTimes.clear();
    }
}
