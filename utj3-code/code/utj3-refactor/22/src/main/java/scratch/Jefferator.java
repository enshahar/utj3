/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package scratch;

import java.util.List;

public class Jefferator implements JeffIterator<Integer> {
    private final List<Integer> list;
    private int currentIndex = -1;

    public Jefferator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return currentIndex + 1 < list.size();
    }

    @Override
    public Integer current() {
        if (currentIndex == -1)
            throw new RuntimeException("iterator out of bounds");
        return list.get(currentIndex);
    }

    @Override
    public void next() {
        currentIndex++;
    }
}
