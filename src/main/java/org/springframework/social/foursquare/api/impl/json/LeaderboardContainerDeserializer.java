package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Leaderboard;

import java.io.IOException;

public class LeaderboardContainerDeserializer extends AbstractFoursquareDeserializer<LeaderboardContainer> {

    @Override
    public LeaderboardContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new LeaderboardContainer(deserializeNestedResponseObject(jp, "leaderboard", Leaderboard.class));
    }

}
