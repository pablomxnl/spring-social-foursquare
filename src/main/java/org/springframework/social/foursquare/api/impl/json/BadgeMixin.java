package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.BadgeImage;
import org.springframework.social.foursquare.api.BadgeUnlocks;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BadgeMixin {
    @JsonCreator
    BadgeMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("image") BadgeImage image,
            @JsonProperty("unlocks") List<BadgeUnlocks> unlocks) {
    }
}
