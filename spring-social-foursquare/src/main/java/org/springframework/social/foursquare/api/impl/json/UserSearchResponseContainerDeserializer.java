package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.UserSearchResponse;

public class UserSearchResponseContainerDeserializer extends AbstractFoursquareDeserializer<UserSearchResponseContainer> {
    
    @Override
    public UserSearchResponseContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        
        return deserializeResponseObject(jp, UserSearchResponseContainer.class, UserSearchResponse.class);
    }
    
}
