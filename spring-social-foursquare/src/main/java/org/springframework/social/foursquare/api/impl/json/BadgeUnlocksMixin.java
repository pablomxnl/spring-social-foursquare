package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Checkin;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BadgeUnlocksMixin {
    @JsonCreator
    BadgeUnlocksMixin(
            @JsonProperty("checkins") List<Checkin> checkins){}

}
