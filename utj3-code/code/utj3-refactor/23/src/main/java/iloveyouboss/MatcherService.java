/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

public class MatcherService {
    class ProfileData { Profile retrieve(int id) { return null; } }
    class CriteriaData { Criteria retrieve(int id) { return null; } }

    ProfileData profileData = new ProfileData();
    CriteriaData criteriaData = new CriteriaData();

    public boolean matches(int profileId, int criteriaId) {
        var profile = profileData.retrieve(profileId);
        var criteria = criteriaData.retrieve(criteriaId);
        return new Matcher(criteria, profile.answers()).matches();
    }

    public int score(int profileId, int criteriaId) {
        var profile = profileData.retrieve(profileId);
        var criteria = criteriaData.retrieve(criteriaId);
        return new Matcher(criteria, profile.answers()).score();
    }
    // ...
}
