/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package util;

import java.net.MalformedURLException;
import java.net.URL;
import static java.lang.String.format;

public class URLCreator {
   public String create(String server, String document)
         throws MalformedURLException {
      if (isEmpty(document))
         return new URL(format("https://%s", server)).toString();
      return new URL(
         format("https://%s/%s", server, clean(document))).toString();
   }

   private boolean isEmpty(String document) {
      return document == null || document.trim().equals("");
   }

   private String clean(String document) {
      return document.charAt(0) == '/'
         ? document.substring(1)
         : document;
   }
}
