package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.BadgeGroup;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BadgeSetsMixin {
    @JsonCreator
    BadgeSetsMixin(@JsonProperty("groups") List<BadgeGroup> groups) {
    }
}
