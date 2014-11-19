package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.*;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class FoursquareUserMixin {

    @JsonCreator
    FoursquareUserMixin(
            @JsonProperty("id") String id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("photo") UserPhoto photo,
            @JsonProperty("gender") String gender,
            @JsonProperty("homeCity") String homeCity,
            @JsonProperty("relationship") String relationship) {
    }

    @JsonProperty("type")
    String type;

    @JsonProperty("pings")
    boolean pings;

    @JsonProperty("contact")
    ContactInfo contactInfo;

    @JsonProperty("mayorships")
    MayorshipInfo mayorshipInfo;

    @JsonProperty("checkins")
    CheckinInfo checkinInfo;

    @JsonProperty("friends")
    FriendInfo friendInfo;

    @JsonProperty("scores")
    Scores scores;

}
