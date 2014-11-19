package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.UserSearchResponse;

import java.io.IOException;

public class UserSearchResponseContainerDeserializer extends AbstractFoursquareDeserializer<UserSearchResponseContainer> {

    @Override
    public UserSearchResponseContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        return deserializeResponseObject(jp, UserSearchResponseContainer.class, UserSearchResponse.class);
    }

}
