package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Tip;

public class TipsListContainerDeserializer extends AbstractFoursquareDeserializer<TipsListContainer> {

	@SuppressWarnings("unchecked")
	@Override
	public TipsListContainer deserialize(JsonParser jp,
			DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
		return new TipsListContainer((List<Tip>) deserializeNestedList(jp, "tips", new TypeReference<List<Tip>>() { }));
	}
}
