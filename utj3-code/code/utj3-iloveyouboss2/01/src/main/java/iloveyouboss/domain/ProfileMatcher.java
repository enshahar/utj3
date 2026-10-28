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
import java.util.concurrent.*;

public class ProfileMatcher {
   private List<Profile> profiles = new ArrayList<>();

   public void addProfile(Profile profile) {
      profiles.add(profile);
   }

   ExecutorService executorService =
      Executors.newFixedThreadPool(8);

   public Map<Profile, Integer> scoreProfiles(Criteria criteria)
      throws ExecutionException, InterruptedException {
      var profiles = new HashMap<Profile, Integer>();

      var futures = new ArrayList<Future<Void>>();
      for (var profile: this.profiles) {
         futures.add(executorService.submit(() -> {
            profiles.put(profile,
               profile.matches(criteria) ? profile.score(criteria) : 0);
            return null;
         }));
      }

      for (var future: futures)
         future.get();

      executorService.shutdown();
      return profiles;
   }
}
