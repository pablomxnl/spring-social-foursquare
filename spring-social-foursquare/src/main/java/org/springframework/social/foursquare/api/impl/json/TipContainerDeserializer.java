package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Tip;

public class TipContainerDeserializer extends AbstractFoursquareDeserializer<TipContainer> {
	
	@Override
	public TipContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new TipContainer(deserializeNestedResponseObject(jp, "tip", Tip.class));
	}
	
}
