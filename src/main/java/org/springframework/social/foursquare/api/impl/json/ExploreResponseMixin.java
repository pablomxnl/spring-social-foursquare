package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Keywords;
import org.springframework.social.foursquare.api.VenueGroup;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ExploreResponseMixin {
    @JsonCreator
    ExploreResponseMixin(
            @JsonProperty("keywords") Keywords keywords,
            @JsonProperty("groups") List<VenueGroup> groups,
            @JsonProperty("warning") Map<String, Object> warning) {
    }
}
