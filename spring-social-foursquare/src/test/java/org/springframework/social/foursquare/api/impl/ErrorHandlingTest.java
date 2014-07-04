package org.springframework.social.foursquare.api.impl;

import static org.springframework.http.HttpMethod.GET;

import static org.springframework.test.web.client.response.MockRestResponseCreators.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.social.InsufficientPermissionException;
import org.springframework.social.InternalServerErrorException;
import org.springframework.social.NotAuthorizedException;
import org.springframework.social.RateLimitExceededException;
import org.springframework.social.ResourceNotFoundException;
import org.springframework.social.foursquare.api.FoursquareApiException;
import org.springframework.social.foursquare.api.ParamErrorException;

public class ErrorHandlingTest extends AbstractFoursquareApiTest {

	private String errorTemplate = "{\"meta\":{\"code\":400,\"errorType\": \"{error_type}\",\"errorDetail\": \"{error_detail}\"},\"response\":{}}";

	private String getErrorResponse(String type, String detail) {
		return errorTemplate.replace("{error_type}", type).replace(
				"{error_detail}", detail);
	}

	@Test(expected = NotAuthorizedException.class)
	public void badRequest() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest().body(
								getErrorResponse("invalid_auth",
										"Invalid authentication")).headers(
								responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

	@Test(expected = ParamErrorException.class)
	public void paramError() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest()
								.body(getErrorResponse("param_error",
										"Invalid param")).headers(
										responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

	@Test(expected = ResourceNotFoundException.class)
	public void endpointError() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest().body(
								getErrorResponse("endpoint_error",
										"Endpoint error")).headers(
								responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

	@Test(expected = InsufficientPermissionException.class)
	public void notAuthorized() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest().body(
								getErrorResponse("not_authorized",
										"Not authorized")).headers(
								responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

	@Test(expected = RateLimitExceededException.class)
	public void rateLimit() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest().body(
								getErrorResponse("rate_limit_exceeded",
										"Rate limit")).headers(responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

	@Test(expected = InternalServerErrorException.class)
	public void internalServerError() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest().body(
								getErrorResponse("server_error",
										"Internal server error")).headers(
								responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

	@Test(expected = FoursquareApiException.class)
	public void otherError() {
		mockServer
				.expect(requestTo("https://api.foursquare.com/v2/venues/VENUE_ID?oauth_token=ACCESS_TOKEN&v=20120609"))
				.andExpect(method(GET))
				.andRespond(
						withBadRequest().body(
								getErrorResponse("other", "Some other error"))
								.headers(responseHeaders));

		foursquare.venueOperations().getVenue("VENUE_ID");
	}

}
