/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package credit;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class CreditHistory {
   private final List<CreditRating> ratings = new ArrayList<>();
   
   public void add(CreditRating rating) {
      ratings.add(rating);
   }
   
   public int arithmeticMean() {
      var total = ratings.stream().mapToInt(CreditRating::rating).sum();
      return total / ratings.size();
   }

   public static void main(String[] args) {
      var collection = new CreditHistory();
      collection.add(new CreditRating(745));
      collection.add(new CreditRating(714));
      collection.add(new CreditRating(758));
      collection.add(new CreditRating(805));

      System.out.println("average: " + collection.arithmeticMean());
   }
}
