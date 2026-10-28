/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package com.langrsoft.util;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpImpl implements Http {
  @Override
  public String get(String url) {
    try (var client = HttpClient.newHttpClient()) {
      var request = HttpRequest.newBuilder().uri(URI.create(url)).build();
      try {
        var httpResponse = client.send(request, BodyHandlers.ofString());
        return httpResponse.body();
      } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
