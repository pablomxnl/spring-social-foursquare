package org.springframework.social.foursquare.api;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class VenueBeenHereTest {

    @Test
    public void shouldParseCount() throws JsonParseException, JsonMappingException, IOException {
        String beenHereJson = "{\"count\":3}";
        ObjectMapper mapper = new ObjectMapper();
        VenueBeenHere beenHere = mapper.readValue(beenHereJson, VenueBeenHere.class);
        assertEquals(3, beenHere.getCount());
        assertFalse(beenHere.isMarked());
    }

    @Test
    public void shouldParseCountAndMarkedFalse() throws JsonParseException, JsonMappingException, IOException {
        String beenHereJson = "{\"count\":3, \"marked\":false}";
        ObjectMapper mapper = new ObjectMapper();
        VenueBeenHere beenHere = mapper.readValue(beenHereJson, VenueBeenHere.class);
        assertEquals(3, beenHere.getCount());
        assertFalse(beenHere.isMarked());
    }

    @Test
    public void shouldParseCountAndMarkedTrue() throws JsonParseException, JsonMappingException, IOException {
        String beenHereJson = "{\"count\":3, \"marked\":true}";
        ObjectMapper mapper = new ObjectMapper();
        VenueBeenHere beenHere = mapper.readValue(beenHereJson, VenueBeenHere.class);
        assertEquals(3, beenHere.getCount());
        assertTrue(beenHere.isMarked());
    }
}
