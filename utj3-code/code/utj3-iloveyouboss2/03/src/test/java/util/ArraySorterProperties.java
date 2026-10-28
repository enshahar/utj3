/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import static java.util.Arrays.fill;
import static java.util.Arrays.sort;
import net.jqwik.api.*;
import java.util.Arrays;

public class ArraySorterProperties {
   ArraySorter arraySorter = new ArraySorter();

   @Property
   boolean returnsSameArrayWhenAlreadySorted(@ForAll int[] array) {
      sort(array);
      var expected = array.clone();

      arraySorter.inPlaceInsertionSort(array);

      return Arrays.equals(expected, array);
   }

   @Property
   boolean returnsSameArrayWhenAllSameElements(@ForAll int element) {
      var array = new int[12];
      fill(array, element);
      var expected = array.clone();

      arraySorter.inPlaceInsertionSort(array);

      return Arrays.equals(expected, array);
   }

   @Property
   boolean sortsAscendingWhenRandomUnsortedArray(@ForAll int[] array) {
      var expected = array.clone();
      sort(expected);

      arraySorter.inPlaceInsertionSort(array);

      return Arrays.equals(expected, array);
   }
}
