package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.CheckinComment;

public class CheckinCommentContainerDeserializer extends AbstractFoursquareDeserializer<CheckinCommentContainer> {
	@Override
	public CheckinCommentContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new CheckinCommentContainer(deserializeNestedResponseObject(jp, "comment", CheckinComment.class));
	}
}
