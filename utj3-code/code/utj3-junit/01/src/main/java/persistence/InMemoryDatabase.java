/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package persistence;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
   Map<String, Customer> data = new HashMap<>();

   public void add(Customer customer) {
      data.put(customer.id(), new Customer(customer));
   }

   public void addBad(Customer customer) {
      data.put(customer.id(), customer);
   }

   // ...
   public Customer get(String id) {
      return data.getOrDefault(id, null);
   }
}
