package org.springframework.social.foursquare.api.impl;

import org.junit.Test;
import org.springframework.social.foursquare.api.AllSettings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class SettingTemplateTest extends AbstractFoursquareApiTest {

    @Test
    public void getAll() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/settings/all?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/allsettings.json")).headers(responseHeaders));

        AllSettings settings = foursquare.settingOperations().getAll();
        assertTrue(settings.receivePings());
        mockServer.verify();
    }

    @Test
    public void getSetting() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/settings/SETTING_ID?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(GET))
                .andRespond(withSuccess().body(read("/testdata/booleansetting.json")).headers(responseHeaders));

        Boolean setting = foursquare.settingOperations().getSetting("SETTING_ID");
        assertTrue(setting);
        mockServer.verify();
    }

    @Test
    public void setSetting() {
        mockServer.expect(requestTo("https://api.foursquare.com/v2/settings/SETTING_ID/set?oauth_token=ACCESS_TOKEN&v=" + API_VERSION))
                .andExpect(method(POST))
                .andExpect(content().string("value=1"))
                .andRespond(withSuccess().body(read("/testdata/setsetting.json")).headers(responseHeaders));

        String msg = foursquare.settingOperations().setSetting("SETTING_ID", true);
        assertEquals("done", msg);
        mockServer.verify();
    }

}
