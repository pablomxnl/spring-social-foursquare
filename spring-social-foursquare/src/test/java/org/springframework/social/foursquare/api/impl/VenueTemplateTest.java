package org.springframework.social.foursquare.api.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.CheckinInfo;
import org.springframework.social.foursquare.api.ExploreQuery;
import org.springframework.social.foursquare.api.ExploreResponse;
import org.springframework.social.foursquare.api.Location;
import org.springframework.social.foursquare.api.Tips;
import org.springframework.social.foursquare.api.Todo;
import org.springframework.social.foursquare.api.Venue;
import org.springframework.social.foursquare.api.VenueLinks;
import org.springframework.social.foursquare.api.Photos;
import org.springframework.social.foursquare.api.VenueSearchParams;

public class VenueTemplateTest extends AbstractFoursquareApiTest {

	@Test
	public void getVenue() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(GET))
				.andRespond(
						withSuccess().body(
								read("testdata/venue.json")).headers(responseHeaders));

		Venue venue = foursquare.venueOperations().getVenue("VENUE_ID");
		assertEquals("40a55d80f964a52020f31ee3", venue.getId());
		Location location = venue.getLocation();
		assertNotNull(location);
		assertEquals("4 Clinton St", location.getAddress());
		assertEquals("at E Houston St", location.getCrossStreet());
		assertEquals("NY", location.getState());
		assertEquals("New York", location.getCity());
		assertEquals("10002", location.getPostalCode());
		assertEquals("United States", location.getCountry());
		assertEquals(40.721294d, location.getLatitude(), 0d);
		assertEquals(-73.983994, location.getLongitude(), 0d);
		assertTrue(venue.getPhotos().getGroups().size() > 0);
		assertTrue(venue.getPhotos().getGroups().get(0).getItems().size() > 0);
		assertEquals("https://irs2.4sqi.net/img/general/690170_HnduV5yM9RLNUHQseOOvDi3OCm4AoYmMld79iVTxrPg.jpg",venue.getPhotos().getGroups().get(0).getItems().get(0).getUrl());
		mockServer.verify();
	}

	@Test
	public void addVenue() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/add?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(POST))
				.andExpect(
						content()
								.string("name=NAME&address=ADDRESS&crossStreet=CROSSSTREET&city=CITY&state=STATE&zip=ZIP&phone=PHONE&ll=1.0%2C1.0&primaryCategoryId=CATEGORYID"))
				.andRespond(
						withSuccess().body(
								read("testdata/venue.json")).headers(responseHeaders));

		Venue venue = foursquare.venueOperations().addVenue("NAME", "ADDRESS",
				"CROSSSTREET", "CITY", "STATE", "ZIP", "PHONE", 1, 1,
				"CATEGORYID");
		assertEquals("3fd66200f964a520dbe91ee3", venue.getId());
		mockServer.verify();

	}

	@Test
	public void getCategories() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/categories?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(GET))
				.andRespond(
						withSuccess()
								.body(read(
										"testdata/categories.json"))
								.headers(responseHeaders));

		List<Category> categories = foursquare.venueOperations()
				.getCategories();
		mockServer.verify();
		assertTrue(categories.size() > 0);
	}

	@Test
	public void explore() {
	
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/explore?oauth_token=ACCESS_TOKEN&v="+API_VERSION+"&ll=10.0%2C10.0&query=QUERY"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess().body(read("testdata/venue-search.json")).headers(responseHeaders));

		ExploreQuery query = new ExploreQuery().location(10d, 10d).query(
				"QUERY");
		ExploreResponse response = foursquare.venueOperations().explore(query);
		mockServer.verify();
		assertEquals(30, response.getKeywords().getCount());
	}

	@Test
	public void search() {

		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/search?oauth_token=ACCESS_TOKEN&v="+API_VERSION+"&ll=10.0%2C10.0&query=QUERY"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess().body(
								read(
										"testdata/venue-search.json")).headers(responseHeaders));

		VenueSearchParams query = new VenueSearchParams().location(10d, 10d)
				.query("QUERY");
		List<Venue> results = foursquare.venueOperations().search(query);
		mockServer.verify();
		assertTrue(results.size() > 0);
		assertEquals("Stockwell", results.get(0).getName());
	}

	@Test
	public void getTrending() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/trending?oauth_token=ACCESS_TOKEN&v="+API_VERSION+"&ll=10.0%2C10.0&radius=100"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess().body(
								read("testdata/trending.json")).headers(responseHeaders));

		List<Venue> results = foursquare.venueOperations().getTrending(10d,
				10d, 100, 0);
		assertTrue(results.size() > 0);
		mockServer.verify();
	}

	@Test
	public void getHereNow() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/herenow?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(GET))
				.andRespond(
						withSuccess().body(
								read("testdata/herenow.json")).headers(responseHeaders));

		CheckinInfo herenow = foursquare.venueOperations().getHereNow(
				"VENUE_ID", 0, 0, 0);
		assertTrue(herenow.getCheckins().size() > 0);
		mockServer.verify();
	}

	@Test
	public void getTips() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/tips?oauth_token=ACCESS_TOKEN&v="+API_VERSION+"&sort=popular"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess().body(
								read("testdata/tips.json")).headers(responseHeaders));

		Tips tips = foursquare.venueOperations()
				.getTips("VENUE_ID", null, 0, 0);
		assertTrue(tips.getItems().size() > 0);
		mockServer.verify();
	}

	@Test
	public void getPhotos() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/photos?oauth_token=ACCESS_TOKEN&v="+API_VERSION+"&group=venue"))
				.andExpect(method(GET))
				.andRespond(
						withSuccess()
								.body(read(
										"testdata/venuephotos.json"))
								.headers(responseHeaders));

		Photos photos = foursquare.venueOperations().getPhotos("VENUE_ID",
				null, 0, 0);
		assertTrue(photos.getItems().size() > 0);
		mockServer.verify();
	}

	@Test
	public void getLinks() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/links?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(GET))
				.andRespond(
						withSuccess()
								.body(read(
										"testdata/venuelinks.json"))
								.headers(responseHeaders));

		VenueLinks links = foursquare.venueOperations().getLinks("VENUE_ID");
		assertTrue(links.getItems().size() > 0);
		mockServer.verify();
	}

	@Test
	public void markTodo() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/marktodo?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(POST))
				.andExpect(content().string("text=TEXT"))
				.andRespond(
						withSuccess().body(
								read("testdata/marktodo.json")).headers(responseHeaders));

		Todo todo = foursquare.venueOperations().markTodo("VENUE_ID", "TEXT");
		assertTrue(todo != null);
		mockServer.verify();
	}

	@Test
	public void flag() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/flag?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(POST))
				.andExpect(content().string("problem=closed"))
				.andRespond(
						withSuccess()
								.body(read(
										"testdata/ok-response.json"))
								.headers(responseHeaders));

		foursquare.venueOperations().flag("VENUE_ID", "closed");
		mockServer.verify();
	}

	@Test
	public void edit() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/edit?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(POST))
				.andExpect(
						content()
								.string("name=NAME&address=ADDRESS&crossStreet=CROSSSTREET&city=CITY&state=STATE&zip=ZIP&phone=PHONE&ll=1.0%2C1.0&categoryId=CATEGORYID"))
				.andRespond(
						withSuccess()
								.body(read(
										"testdata/ok-response.json"))
								.headers(responseHeaders));

		foursquare.venueOperations().edit("VENUE_ID", "NAME", "ADDRESS",
				"CROSSSTREET", "CITY", "STATE", "ZIP", "PHONE", 1, 1,
				"CATEGORYID");
		mockServer.verify();
	}

	@Test
	public void proposeEdit() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID/proposeedit?oauth_token=ACCESS_TOKEN&v="+API_VERSION))
				.andExpect(method(POST))
				.andExpect(
						content()
								.string("name=NAME&address=ADDRESS&crossStreet=CROSSSTREET&city=CITY&state=STATE&zip=ZIP&phone=PHONE&ll=1.0%2C1.0&primaryCategoryId=CATEGORYID"))
				.andRespond(
						withSuccess()
								.body(read(
										"testdata/ok-response.json"))
								.headers(responseHeaders));

		foursquare.venueOperations().proposeEdit("VENUE_ID", "NAME", "ADDRESS",
				"CROSSSTREET", "CITY", "STATE", "ZIP", "PHONE", 1, 1,
				"CATEGORYID");
		mockServer.verify();
	}
}
