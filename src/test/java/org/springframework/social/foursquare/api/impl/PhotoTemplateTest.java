package org.springframework.social.foursquare.api.impl;

import org.junit.Test;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.social.foursquare.api.Photo;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class PhotoTemplateTest extends AbstractFoursquareApiTest {

    @Test
    public void get() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/PHOTO_ID?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/photo.json")).headers(responseHeaders));

        Photo photo = foursquare.photoOperations().get("PHOTO_ID");
        assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
        mockServer.verify();
    }

    @Test
    public void addToCheckin() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/add?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/photo.json")).headers(responseHeaders));

        Photo photo = foursquare.photoOperations().addToCheckin("CHECKIN_ID", getUploadResource("image.jpg", "IMAGE DATA"), null, null, null, null, null, null);
        assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
        mockServer.verify();
    }

    @Test
    public void addToTip() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/add?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/photo.json")).headers(responseHeaders));

        Photo photo = foursquare.photoOperations().addToTip("TIP_ID", getUploadResource("image.jpg", "IMAGE DATA"), null, null, null, null, null, null);
        assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
        mockServer.verify();
    }

    @Test
    public void addToVenue() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/photos/add?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andRespond(withSuccess().body(read("/testdata/photo.json")).headers(responseHeaders));

        Photo photo = foursquare.photoOperations().addToVenue("VENUE_ID", getUploadResource("image.jpg", "IMAGE DATA"), null, null, null, null, null, null);
        assertEquals("4d0fb8162d39a340637dc42b", photo.getId());
        mockServer.verify();
    }

    private Resource getUploadResource(final String filename, String content) {
        Resource res = new ByteArrayResource(content.getBytes()) {
            public String getFilename() throws IllegalStateException {
                return filename;
            }

            ;
        };
        return res;
    }
}
