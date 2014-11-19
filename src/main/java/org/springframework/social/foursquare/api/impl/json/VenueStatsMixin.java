package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VenueStatsMixin {
    @JsonCreator
    VenueStatsMixin(
            @JsonProperty("checkinsCount") int checkinsCount,
            @JsonProperty("usersCount") int usersCount) {
    }

}
