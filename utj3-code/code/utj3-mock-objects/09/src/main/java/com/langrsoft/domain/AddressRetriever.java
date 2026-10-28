/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package com.langrsoft.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.langrsoft.util.Http;
import com.langrsoft.util.HttpImpl;

public class AddressRetriever {
    private Auditor auditor = new ApplicationAuditor();
    private static final String SERVER =
       "https://nominatim.openstreetmap.org";
    private Http http = new HttpImpl(); // 이 변수는 final 로 선언할 수 없음

    public Address retrieve(double latitude, double longitude) {
    // ...
        var locationParams = "lat=%.6f&lon=%.6f".formatted(latitude, longitude);
        var url = "%s/reverse?%s&format=json".formatted(SERVER, locationParams);

        var jsonResponse = get(url);
        if (jsonResponse == null) return null;
        // ...

        var response = parseResponse(jsonResponse);

        var address = response.address();
        var country = address.country_code();
        if (!country.equals("us")) {
            auditor.audit("국가 코드 요청: %s".formatted(country));
            throw new UnsupportedOperationException("국제 주소 미지원");
        }

        return address;
    }

    private String get(String url) {
        try {
            return http.get(url);
        }
        catch (Exception e) {
            return null;
        }
    }


    private Response parseResponse(String jsonResponse) {
        var mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return mapper.readValue(jsonResponse, Response.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    // ...
}
