package org.springframework.social.foursquare.api.impl.json;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Badge;
import org.springframework.social.foursquare.api.BadgeSets;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BadgesResponseMixin {
    @JsonCreator
    BadgesResponseMixin(
            @JsonProperty("sets") BadgeSets sets,
            @JsonProperty("badges") Map<String,Badge> badges){}
}
