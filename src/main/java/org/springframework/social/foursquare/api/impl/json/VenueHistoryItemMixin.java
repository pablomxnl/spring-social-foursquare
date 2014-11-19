package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VenueHistoryItemMixin {
    @JsonCreator
    VenueHistoryItemMixin(
            @JsonProperty("beenHere") int beenHere,
            @JsonProperty("venue") Venue venue) {
    }
}
