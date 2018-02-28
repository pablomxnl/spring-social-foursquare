package org.springframework.social.foursquare.api.impl;

import org.junit.Test;
import org.springframework.social.foursquare.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class UserTemplateTest extends AbstractFoursquareApiTest {

    @Test
    public void getUser() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/user-profile.json")).headers(responseHeaders));

        FoursquareUser user = foursquare.userOperations().getUser();
        mockServer.verify();
        assertProfile(user);
    }

    @Test
    public void getLeaderboard() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/leaderboard?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/leaderboard.json")).headers(responseHeaders));

        Leaderboard leaderboard = foursquare.userOperations().getLeaderboard();
        mockServer.verify();
        assertEquals(23, leaderboard.getCount());
    }

    @Test
    public void searchWithParameters() {
        mockServer.expect(anything())
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/user-search.json")).headers(responseHeaders));

        UserSearchResponse results = foursquare.userOperations().search(Arrays.asList("123"),
                Arrays.asList("john@doe.com"), Arrays.asList("matt"), Arrays.asList("321"));

        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }

    @Test
    public void searchName() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&name=matt"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/user-search.json")).headers(responseHeaders));

        UserSearchResponse results = foursquare.userOperations().searchByName("matt");
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }

    @Test
    public void searchTwitterFriends() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/search?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&twitterSource=matt"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/user-search.json")).headers(responseHeaders));

        UserSearchResponse results = foursquare.userOperations().searchTwitterFriends("matt");
        assertEquals(3, results.getResults().size());
        mockServer.verify();
    }

    @Test
    public void getRequests() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/requests?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/requests.json")).headers(responseHeaders));

        List<FoursquareUser> requests = foursquare.userOperations().getRequests();
        assertEquals(3, requests.size());
        mockServer.verify();
    }

    @Test
    public void getCheckins() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/checkins?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/checkins.json")).headers(responseHeaders));

        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins();
        assertEquals(562, checkinInfo.getTotal());
        assertTrue(checkinInfo.getCheckins().get(0) != null);
        mockServer.verify();
    }

    @Test
    public void getCheckinsWithOffset() {
        mockServer.expect(anything())
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/checkins.json")).headers(responseHeaders));

        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins(100, 50);
        assertTrue(checkinInfo.getCheckins().get(0) != null);
        mockServer.verify();
    }

    @Test
    public void getCheckinsWithTimestamps() {
        mockServer.expect(anything())
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/checkins.json")).headers(responseHeaders));

        CheckinInfo checkinInfo = foursquare.userOperations().getCheckins(500, 600, 100, 50);
        assertTrue(checkinInfo.getCheckins().get(0) != null);
        mockServer.verify();
    }

    @Test
    public void getFriends() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/friends?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/friends.json")).headers(responseHeaders));

        Friends friends = foursquare.userOperations().getFriends();
        assertEquals(6, friends.getCount());
        assertEquals(6, friends.getItems().size());
        mockServer.verify();
    }

    @Test
    public void getTips() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/tips?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&sort=recent"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/tips.json")).headers(responseHeaders));

        Tips tips = foursquare.userOperations().getRecentTips(0, 0);
        assertEquals(3, tips.getCount());
        assertTrue(tips.getItems().get(0) != null);
        mockServer.verify();
    }

    @Test
    public void getTodos() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/todos?oauth_token=ACCESS_TOKEN&v=" + API_VERSION + "&sort=recent"))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/todos.json")).headers(responseHeaders));

        Todos todos = foursquare.userOperations().getRecentTodos();
        assertEquals(2, todos.getCount());
        assertTrue(todos.getItems().get(0) != null);
        assertTrue(todos.getItems().get(0).getTip() != null);
        mockServer.verify();
    }

    @Test
    public void getVenueHistory() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/self/venuehistory?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/venue-history.json")).headers(responseHeaders));

        VenueHistory history = foursquare.userOperations().getVenueHistory(0, 0, null);
        assertEquals(163, history.getCount());
        assertEquals(1, history.getItems().get(0).getBeenHere());
        assertTrue(history.getItems().get(0).getVenue() != null);
        mockServer.verify();
    }

    @Test
    public void requestFriend() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/request?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/ok-response.json")).headers(responseHeaders));

        foursquare.userOperations().requestFriend("USER_ID");
    }

    @Test
    public void removeFriend() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/unfriend?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/ok-response.json")).headers(responseHeaders));

        foursquare.userOperations().removeFriend("USER_ID");
    }

    @Test
    public void approveFriend() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/approve?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/ok-response.json")).headers(responseHeaders));

        foursquare.userOperations().approveFriend("USER_ID");
    }

    @Test
    public void denyFriend() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/deny?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/ok-response.json")).headers(responseHeaders));

        foursquare.userOperations().denyFriend("USER_ID");
    }

    @Test
    public void setPings() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/users/USER_ID/setpings?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andExpect(content().string("value=true"))
                .andRespond(withSuccess().body(read("/testdata/ok-response.json")).headers(responseHeaders));

        foursquare.userOperations().setPings("USER_ID", true);
    }
}
