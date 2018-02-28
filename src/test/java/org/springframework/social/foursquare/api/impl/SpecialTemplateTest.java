package org.springframework.social.foursquare.api.impl;

import org.junit.Test;
import org.springframework.social.foursquare.api.Special;
import org.springframework.social.foursquare.api.Specials;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class SpecialTemplateTest extends AbstractFoursquareApiTest {

    @Test
    public void get() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/specials/SPECIAL_ID?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&venueId=VENUE_ID"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/special.json")).headers(responseHeaders));

        Special special = foursquare.specialOperations().get("SPECIAL_ID", "VENUE_ID");
        assertEquals("4cfc5c5ffabc2d437522ddd2", special.getId());
        mockServer.verify();
    }

    @Test
    public void search() {
        mockServer.expect(anything())
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/searchspecials.json")).headers(responseHeaders));

        Specials specials = foursquare.specialOperations().search(10d, 10d, 100l, 10d, 100l, 10);
        assertEquals(30, specials.getCount());
        mockServer.verify();
    }

}
