package org.springframework.social.foursquare.api.impl;

import org.junit.Test;
import org.springframework.social.foursquare.api.Checkin;
import org.springframework.social.foursquare.api.CheckinComment;
import org.springframework.social.foursquare.api.CheckinParams;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class CheckinTemplateTest extends AbstractFoursquareApiTest {

    @Test
    public void get() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/CHECKIN_ID?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/checkin.json")).headers(responseHeaders));

        Checkin checkin = foursquare.checkinOperations().get("CHECKIN_ID");
        assertEquals("4d627f6814963704dc28ff94", checkin.getId());
        mockServer.verify();
    }

    public void add() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/add?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andExpect(content().string("venueId=VENUE_ID&shout=SHOUT&broadcast=public&ll=10.0,10.0&llAcc=10&alt=200.0&altAcc=10"))
                .andRespond(withSuccess().body(read("testdata/checkin.json")).headers(responseHeaders));

        CheckinParams params = new CheckinParams().venueId("VENUE_ID").shout("SHOUT").broadcast("public").latitude(10d).longitude(10d).locationAccuracy(10l).altitude(200d).altitudeAccuracy(10l);
        Checkin checkin = foursquare.checkinOperations().add(params);
        assertEquals("4d627f6814963704dc28ff94", checkin.getId());
        mockServer.verify();
    }

    @Test
    public void getRecent() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/recent?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&limit=10&afterTimestamp=1000&ll=10.0%2C10.0"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/recentcheckins.json")).headers(responseHeaders));

        List<Checkin> checkins = foursquare.checkinOperations().getRecent(10d, 10d, 1000l, 10);
        assertTrue(checkins.size() > 0);
        assertEquals("John", checkins.get(0).getUser().getFirstName());
        mockServer.verify();
    }

    @Test
    public void addComment() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/CHECKIN_ID/addcomment?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andExpect(content().string("text=COMMENT_TEXT"))
                .andRespond(withSuccess().body(read("/testdata/checkincomment.json")).headers(responseHeaders));

        CheckinComment comment = foursquare.checkinOperations().addComment("CHECKIN_ID", "COMMENT_TEXT");
        assertEquals("commentid", comment.getId());
        mockServer.verify();
    }

    @Test
    public void deleteComment() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/checkins/CHECKIN_ID/deletecomment?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andExpect(content().string("commentId=COMMENT_ID"))
                .andRespond(withSuccess().body(read("/testdata/checkin.json")).headers(responseHeaders));

        Checkin checkin = foursquare.checkinOperations().deleteComment("CHECKIN_ID", "COMMENT_ID");
        assertTrue(checkin != null);
        mockServer.verify();
    }
}
