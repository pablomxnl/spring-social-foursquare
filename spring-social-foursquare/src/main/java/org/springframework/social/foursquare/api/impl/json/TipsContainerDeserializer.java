package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Tips;

public class TipsContainerDeserializer extends AbstractFoursquareDeserializer<TipsContainer> {
	@Override
	public TipsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new TipsContainer(deserializeNestedResponseObject(jp, "tips", Tips.class));
	}
}
