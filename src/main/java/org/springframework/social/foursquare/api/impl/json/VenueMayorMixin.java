package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VenueMayorMixin {
    @JsonCreator
    VenueMayorMixin(
            @JsonProperty("count") int count,
            @JsonProperty("user") FoursquareUser user) {
    }
}
