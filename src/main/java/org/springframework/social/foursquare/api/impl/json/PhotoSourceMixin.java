package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhotoSourceMixin {
    @JsonCreator
    PhotoSourceMixin(
            @JsonProperty("name") String name,
            @JsonProperty("url") String url) {
    }
}
