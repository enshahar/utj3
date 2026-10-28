/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit, Third Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit https://pragprog.com/titles/utj3 for more book information.
***/
package com.langrsoft.domain;

import org.junit.jupiter.api.*;

import com.langrsoft.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
// ...
import static org.mockito.Mockito.never;
import static org.mockito.ArgumentMatchers.any;
// ...
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AnAddressRetriever {
    @InjectMocks
    AddressRetriever retriever;

    @Mock
    Auditor auditor;
    @Mock
    Http http;

    @Test
    void answersAppropriateAddressForValidCoordinates() {
        when(http.get(and(contains("lat=38.000000"), contains("lon=-104.000000"))))
           .thenReturn("""
                {"address":{
                  "house_number":"324",
                  "road":"Main St",
                  "city":"Anywhere",
                  "state":"Colorado",
                  "postcode":"81234",
                  "country_code":"us"}}
                """);

        var address = retriever.retrieve(38, -104);

        assertEquals("324", address.house_number());
        assertEquals("Main St", address.road());
        assertEquals("Anywhere", address.city());
        assertEquals("Colorado", address.state());
        assertEquals("81234", address.postcode());
    }

    @Test
    void throwsWhenNotUSCountryCode() {
        when(http.get(anyString())).thenReturn("""
            {"address":{ "country_code":"not us"}}""");

        assertThrows(UnsupportedOperationException.class,
            () -> retriever.retrieve(1.0, -1.0));
    }

    @Nested
    class Auditing {
    @Test
    void auditsWhenNonUSAddressRetrieved() {
        when(http.get(anyString())).thenReturn("""
           {"address":{ "country_code":"not us"}}""");

        assertThrows(UnsupportedOperationException.class,
           () -> retriever.retrieve(1.0, -1.0));

        verify(auditor).audit("국가 코드 요청: not us");
    }

    @Test
    void doesNotOccurWhenUSAddressRetrieved() {
        when(http.get(anyString())).thenReturn("""
           {"address":{ "country_code":"us"}}""");

        retriever.retrieve(1.0, -1.0);

        verify(auditor, never()).audit(any());
    }
    }
    // ...

   @Disabled("retrieves as of 2024-Jun-11")
   @Tag("slow")
   @Test
   void liveIntegrationTest() {
       var retriever = new AddressRetriever();

       var address = retriever.retrieve(38.8372956, -104.8255679);

       assertEquals("North Cascade Avenue", address.road());
       assertEquals("Colorado Springs", address.city());
       assertEquals("Colorado", address.state());
       assertEquals("80903", address.postcode());
   }
}
