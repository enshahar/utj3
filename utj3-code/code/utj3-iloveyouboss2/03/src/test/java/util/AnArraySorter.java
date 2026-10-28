/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AnArraySorter {
   ArraySorter arraySorter = new ArraySorter();

   @Test
   public void returnsSameOrderWhenAlreadySorted() {
      int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
      arraySorter.inPlaceInsertionSort(array);
      assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, array);
   }

   @Test
   public void returnsUnchangedWhenAllSameElements() {
      int[] array = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

      arraySorter.inPlaceInsertionSort(array);

      assertArrayEquals(
         new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, array);
   }


   @Test
   public void returnsInOrderWhenUnsorted() {
      int[] array = {5, 2, 9, 1, 5, 6, 7, 3, 4, 8, 0, 11};

      arraySorter.inPlaceInsertionSort(array);

      assertArrayEquals(
         new int[]{0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 11}, array);
   }

   @Disabled
   @Test
   public void returnsInOrderWhenAlreadySortedExceptLast() {
      int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};

      arraySorter.inPlaceInsertionSort(array);

      assertArrayEquals(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, array);
   }
}