package org.springframework.social.foursquare.api.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


public class FoursquareTemplateTest extends AbstractFoursquareApiTest {

    private FoursquareTemplate noAuthFoursquare;

    protected MockRestServiceServer mockServer;

    protected HttpHeaders responseHeaders;

    @Before
    public void setup() {
        noAuthFoursquare = new FoursquareTemplate("CLIENT_ID", "CLIENT_SECRET");
        mockServer = MockRestServiceServer.createServer(noAuthFoursquare.getRestTemplate());
        responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void noAuthGetVenue() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?client_id=CLIENT_ID&client_secret=CLIENT_SECRET&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/venue.json")).headers(responseHeaders));

        Venue venue = noAuthFoursquare.venueOperations().getVenue("VENUE_ID");
        assertEquals("40a55d80f964a52020f31ee3", venue.getId());
        mockServer.verify();
    }

    @Test(expected = MissingAuthorizationException.class)
    public void noAuthCall() {
        noAuthFoursquare.userOperations().getUser();
    }
}
