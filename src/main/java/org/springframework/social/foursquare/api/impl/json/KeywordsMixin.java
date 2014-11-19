package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Keyword;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class KeywordsMixin {
    @JsonCreator
    KeywordsMixin(
            @JsonProperty("count") int count,
            @JsonProperty("items") List<Keyword> items) {
    }
}
