/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

import java.util.*;
import java.util.stream.Stream;
import static java.util.Arrays.asList;

public record Criteria(List<Criterion> criteria) {
    public Criteria(Criterion... criterion) {
        this(asList(criterion));
    }

    public Stream<Criterion> stream() {
        return criteria.stream();
    }
}

