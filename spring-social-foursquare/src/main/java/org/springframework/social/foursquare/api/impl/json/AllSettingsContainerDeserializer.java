package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.AllSettings;

public class AllSettingsContainerDeserializer extends AbstractFoursquareDeserializer<AllSettingsContainer> {
	@Override
	public AllSettingsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new AllSettingsContainer(deserializeNestedResponseObject(jp, "settings", AllSettings.class));
	}
}
