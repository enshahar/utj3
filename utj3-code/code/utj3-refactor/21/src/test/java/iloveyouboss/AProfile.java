/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package iloveyouboss;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static iloveyouboss.Weight.*;
import static iloveyouboss.YesNo.*;
import static org.junit.jupiter.api.Assertions.*;

class AProfile {
    Profile profile = new Profile("Geeks Inc.");
    Criteria criteria;

    Question freeLunch;
    Answer freeLunchYes;
    Answer freeLunchNo;

    Question bonus;
    Answer bonusYes;
    Answer bonusNo;

    Question hasGym;
    Answer hasGymNo;
    Answer hasGymYes;

    String[] NO_YES = {NO.toString(), YES.toString()};

    @BeforeEach
    void createQuestionsAndAnswers() {
        bonus = new Question("Bonus?", NO_YES, 1);
        bonusYes = new Answer(bonus, YES);
        bonusNo = new Answer(bonus, NO);

        freeLunch = new Question("Free lunch?", NO_YES, 1);
        freeLunchYes = new Answer(freeLunch, YES);
        freeLunchNo = new Answer(freeLunch, NO);

        hasGym = new Question("Gym?", NO_YES, 1);
        hasGymYes = new Answer(hasGym, YES);
        hasGymNo = new Answer(hasGym, NO);
    }

    @Nested
    class DoesNotMatch {
        @Test
        void whenAnyRequiredCriteriaNotMet() {
            profile.add(freeLunchNo, bonusYes); // save these args
            criteria = new Criteria(
                    new Criterion(freeLunchYes, REQUIRED),
                    new Criterion(bonusYes, IMPORTANT));

            var matches = profile.matches(criteria); // remove criteria arg

            assertFalse(matches);
        }

        @Test
        void whenNoneOfMultipleCriteriaMatch() {
            profile.add(bonusNo, freeLunchNo);
            criteria = new Criteria(
                new Criterion(bonusYes, IMPORTANT),
                new Criterion(freeLunchYes, IMPORTANT));

            var matches = profile.matches(criteria);

            assertFalse(matches);
        }
    }

    @Nested
    class Matches {
        @Test
        void whenCriteriaIrrelevant() {
            profile.add(freeLunchNo);
            criteria = new Criteria(
                new Criterion(freeLunchYes, IRRELEVANT));

            var matches = profile.matches(criteria);

            assertTrue(matches);
        }

        @Test
        void whenAnyOfMultipleCriteriaMatch() {
            profile.add(bonusYes, freeLunchNo);
            criteria = new Criteria(
                new Criterion(bonusYes, IMPORTANT),
                new Criterion(freeLunchYes, IMPORTANT));

            var matches = profile.matches(criteria);

            assertTrue(matches);
        }
    }

    @Nested
    class Score {
        @Test
        void isZeroWhenThereAreNoMatches() {
            profile.add(bonusNo);
            criteria = new Criteria(
                new Criterion(bonusYes, IMPORTANT));

            profile.matches(criteria);

            assertEquals(0, profile.score());
        }

        @Test
        void doesNotIncludeUnmetRequiredCriteria() {
            profile.add(bonusNo, freeLunchYes);
            criteria = new Criteria(
               new Criterion(bonusYes, REQUIRED),
               new Criterion(freeLunchYes, IMPORTANT));

            profile.matches(criteria);

            assertEquals(IMPORTANT.value(), profile.score());
        }

        @Test
        void equalsCriterionValueForSingleMatch() {
            profile.add(bonusYes);
            criteria = new Criteria(
                new Criterion(bonusYes, IMPORTANT));

            profile.matches(criteria);

            assertEquals(IMPORTANT.value(), profile.score());
        }

        @Test
        void sumsCriterionValuesForMatches() {
            profile.add(bonusYes, freeLunchYes, hasGymNo);
            criteria = new Criteria(
                new Criterion(bonusYes, IMPORTANT),
                new Criterion(freeLunchYes, NICE_TO_HAVE),
                new Criterion(hasGymYes, VERY_IMPORTANT));

            profile.matches(criteria);

            assertEquals(IMPORTANT.value() + NICE_TO_HAVE.value(),
                profile.score());
        }
    }
}
