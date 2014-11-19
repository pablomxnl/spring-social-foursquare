package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.Scores;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class LeaderboardItemMixin {
    @JsonCreator
    LeaderboardItemMixin(
            @JsonProperty("user") FoursquareUser user,
            @JsonProperty("rank") int rank,
            @JsonProperty("scores") Scores scores) {
    }
}
