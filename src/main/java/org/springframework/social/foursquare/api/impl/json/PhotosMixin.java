package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.PhotoGroup;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhotosMixin {
    @JsonCreator
    PhotosMixin(
            @JsonProperty("count") int count,
            @JsonProperty("groups") List<PhotoGroup> groups) {
    }
}
