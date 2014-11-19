package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Reasons;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ReasonsMixin {
    @JsonCreator
    ReasonsMixin(
            @JsonProperty("count") int count,
            @JsonProperty("items") List<Reasons> items) {
    }
}
