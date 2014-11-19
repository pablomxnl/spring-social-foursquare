package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Tip;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TipGroupMixin {
    @JsonCreator
    TipGroupMixin(
            @JsonProperty("type") String type,
            @JsonProperty("name") String name,
            @JsonProperty("count") int count,
            @JsonProperty("items") List<Tip> items) {
    }
}
