/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package com.langrsoft.domain;

import com.langrsoft.util.Http;
import com.langrsoft.util.HttpImpl;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnAddressRetriever {
    @Test
    void answersAppropriateAddressForValidCoordinates() {
        Http http = url -> {
            if (!url.contains("lat=38") ||
                !url.contains("lon=-104"))
                fail("url " + url + " does not contain correct params");
            return """
                {"address":{
                  "house_number":"324",
                  "road":"Main St",
                  "city":"Anywhere",
                  "state":"Colorado",
                  "postcode":"81234",
                  "country_code":"us"}}
                """;
        };
        var retriever = new AddressRetriever(http);

        var address = retriever.retrieve(38, -104);
        // ...

        assertEquals("324", address.house_number());
        assertEquals("Main St", address.road());
        assertEquals("Anywhere", address.city());
        assertEquals("Colorado", address.state());
        assertEquals("81234", address.postcode());
    }

    @Test
    void throwsWhenNotUSCountryCode() {
        Http http = url -> """
            {"address":{ "country_code":"not us"}}""";
        var retriever = new AddressRetriever(http);

        assertThrows(UnsupportedOperationException.class,
            () -> retriever.retrieve(1.0, -1.0));
    }

    @Disabled("calls successfully as of 2024-Jun-11")
    @Tag("slow")
    @Test
    void liveIntegrationTest() {
        var retriever = new AddressRetriever(new HttpImpl());

        var address = retriever.retrieve(38.8372956, -104.8255679);

        assertEquals("North Cascade Avenue", address.road());
        assertEquals("Colorado Springs", address.city());
        assertEquals("Colorado", address.state());
        assertEquals("80903", address.postcode());
    }
}
