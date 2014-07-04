package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.test.web.client.MockRestServiceServer;


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
		mockServer.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?client_id=CLIENT_ID&client_secret=CLIENT_SECRET&v=20120609"))
			.andExpect(method(GET))
			.andRespond(withSuccess().body(read("testdata/venue.json")).headers(responseHeaders));
		
		Venue venue = noAuthFoursquare.venueOperations().getVenue("VENUE_ID");
		assertEquals("3fd66200f964a520dbe91ee3", venue.getId());
		mockServer.verify();
	}
	
	@Test(expected=MissingAuthorizationException.class)
	public void noAuthCall() {
		noAuthFoursquare.userOperations().getUser();
	}
}
