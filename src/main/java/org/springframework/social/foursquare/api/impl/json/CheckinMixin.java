package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.*;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CheckinMixin {
    @JsonCreator
    CheckinMixin(
            @JsonProperty("id") String id,
            @JsonProperty("user") FoursquareUser user,
            @JsonProperty("createdAt") @JsonDeserialize(using = FoursquareDateDeserializer.class) Date createdAt,
            @JsonProperty("type") String type,
            @JsonProperty("timeZone") String timeZone,
            @JsonProperty("venue") Venue venue,
            @JsonProperty("source") CheckinSource source,
            @JsonProperty("comments") CheckinCommentInfo comments) {
    }

    @JsonProperty("isMayor")
    boolean mayor;

    @JsonProperty("shout")
    String shout;

    @JsonProperty("")
    Photos photos;
}
