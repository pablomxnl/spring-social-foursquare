package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Checkin;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BadgeUnlocksMixin {
    @JsonCreator
    BadgeUnlocksMixin(
            @JsonProperty("checkins") List<Checkin> checkins) {
    }

}
