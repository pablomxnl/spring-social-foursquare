package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CheckinCommentMixin {
    // TODO: Determine real checkin comment JSON structure
    @JsonCreator
    CheckinCommentMixin(
            @JsonProperty("id") String id,
            @JsonProperty("text") String text) {
    }
}
