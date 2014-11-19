package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUserGroup;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FriendInfoMixin {
    @JsonCreator
    FriendInfoMixin(
            @JsonProperty("count") int total,
            @JsonProperty("groups") List<FoursquareUserGroup> groups) {
    }
}
