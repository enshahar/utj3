/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import java.net.MalformedURLException;

public class AURLCreatorFuzzer {
   @FuzzTest
   public void fuzzTestIsValidURL(FuzzedDataProvider data)
         throws MalformedURLException {
      var server = data.consumeString(32);
      var document = data.consumeRemainingAsString();
      new URLCreator().create(server, document);
   }
}
