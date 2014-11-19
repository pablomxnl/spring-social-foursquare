package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.LeaderboardItem;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaderboardMixin {
    @JsonCreator
    LeaderboardMixin(
            @JsonProperty("count") int count,
            @JsonProperty("items") List<LeaderboardItem> items) {
    }
}
