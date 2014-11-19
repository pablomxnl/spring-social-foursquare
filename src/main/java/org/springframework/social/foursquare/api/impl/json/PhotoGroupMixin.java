package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.PhotoGroup;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhotoGroupMixin {
    @JsonCreator
    PhotoGroupMixin(
            @JsonProperty("type") String type,
            @JsonProperty("name") String name,
            @JsonProperty("count") int count,
            @JsonProperty("items") List<PhotoGroup> items) {
    }
}
