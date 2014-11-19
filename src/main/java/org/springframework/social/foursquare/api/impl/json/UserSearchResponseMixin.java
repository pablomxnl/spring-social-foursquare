package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class UserSearchResponseMixin {
    @JsonCreator
    UserSearchResponseMixin(
            @JsonProperty("results") List<FoursquareUser> results,
            @JsonProperty("unmatched") Map<String, Object> unmatched) {
    }

}
