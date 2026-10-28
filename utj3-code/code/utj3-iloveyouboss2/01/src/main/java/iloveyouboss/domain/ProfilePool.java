/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss.domain;

import java.util.*;

public class ProfilePool {
   private final List<Profile> profiles = new ArrayList<>();

   public void add(Profile profile) {
      profiles.add(profile);
   }

   public void score(Criteria criteria) {
      profiles.forEach(profile -> profile.matches(criteria));
   }

   public List<Profile> ranked(Criteria criteria) {
      profiles.sort((p1, p2) -> -1 * Integer.compare(p1.score(criteria), p2.score(criteria)));
      return profiles;
   }
}
