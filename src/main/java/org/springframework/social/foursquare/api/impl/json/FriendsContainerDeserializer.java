package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Friends;

import java.io.IOException;

public class FriendsContainerDeserializer extends AbstractFoursquareDeserializer<FriendsContainer> {
    @Override
    public FriendsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new FriendsContainer(deserializeNestedResponseObject(jp, "friends", Friends.class));
    }
}
