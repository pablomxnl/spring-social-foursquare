package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.FoursquareUser;

public class FoursquareUserContainerDeserializer extends AbstractFoursquareDeserializer<FoursquareUserContainer> {
    
	@Override
	public FoursquareUserContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new FoursquareUserContainer(deserializeNestedResponseObject(jp, "user", FoursquareUser.class));
	}
	
	
}
