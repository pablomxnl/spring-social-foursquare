package org.springframework.social.foursquare.api.impl;

import org.junit.Test;
import org.springframework.social.foursquare.api.Tip;
import org.springframework.social.foursquare.api.Todo;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class TipTemplateTest extends AbstractFoursquareApiTest {

    @Test
    public void get() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/tip.json")).headers(responseHeaders));

        Tip tip = foursquare.tipOperations().get("TIP_ID");
        assertEquals("4b5e662a70c603bba7d790b4", tip.getId());
        mockServer.verify();
    }

    @Test
    public void add() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/add?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andExpect(content().string("venueId=VENUE_ID&text=TEXT&url=URL"))
                .andRespond(withSuccess().body(read("/testdata/tip.json")).headers(responseHeaders));

        Tip tip = foursquare.tipOperations().add("VENUE_ID", "TEXT", "URL");
        assertEquals("4b5e662a70c603bba7d790b4", tip.getId());
        mockServer.verify();
    }

    @Test
    public void search() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/search?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&ll=10.0%2C10.0&query=QUERY&offset=10&filter=friends"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/searchtips.json")).headers(responseHeaders));

        List<Tip> tips = foursquare.tipOperations().search(10d, 10d, "QUERY", 10, true);
        assertTrue(tips.size() > 0);
        mockServer.verify();
    }

    @Test
    public void markTodo() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID/marktodo?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/marktodo.json")).headers(responseHeaders));

        Todo todo = foursquare.tipOperations().markTodo("TIP_ID");
        assertTrue(todo != null);
        mockServer.verify();
    }

    @Test
    public void markDone() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID/markdone?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/marktodo.json")).headers(responseHeaders));

        Todo todo = foursquare.tipOperations().markDone("TIP_ID");
        assertTrue(todo != null);
        mockServer.verify();
    }

    @Test
    public void unmark() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/tips/TIP_ID/unmark?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/tip.json")).headers(responseHeaders));

        Tip tip = foursquare.tipOperations().unmarkTodo("TIP_ID");
        assertTrue(tip != null);
        mockServer.verify();
    }
}
