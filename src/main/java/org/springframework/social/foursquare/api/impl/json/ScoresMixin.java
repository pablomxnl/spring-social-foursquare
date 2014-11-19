package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ScoresMixin {
    @JsonCreator
    ScoresMixin(
            @JsonProperty("recent") int recent,
            @JsonProperty("max") int max,
            @JsonProperty("checkinsCount") int checkinsCount) {
    }
}
