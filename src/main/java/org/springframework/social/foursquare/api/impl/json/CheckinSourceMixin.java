package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

abstract class CheckinSourceMixin {
    @JsonCreator
    CheckinSourceMixin(
            @JsonProperty("name") String name,
            @JsonProperty("url") String url) {
    }
}
