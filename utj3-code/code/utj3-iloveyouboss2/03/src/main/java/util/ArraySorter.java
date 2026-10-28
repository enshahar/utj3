/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

public class ArraySorter {
   public void inPlaceInsertionSort(int[] arr) {
      for (var i = 1; i < arr.length - 1; i++) {
         var key = arr[i];
         var j = i - 1;

         while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j = j - 1;
         }
         arr[j + 1] = key;
      }
   }
}

// Defect: The for loop should check up to arr.length, not just arr.length - 1:
//      for (var i = 1; i < arr.length; i++) {
