package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.*;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhotoMixin {
    @JsonCreator
    PhotoMixin(
            @JsonProperty("id") String id,
            @JsonProperty("createdAt") @JsonDeserialize(using = FoursquareDateDeserializer.class) Date createdAt,
            @JsonProperty("prefix") String prefix,
            @JsonProperty("suffix") String suffix,
            @JsonProperty("width") int width,
            @JsonProperty("height") int height,
            @JsonProperty("sizes") PhotoSizes sizes,
            @JsonProperty("user") FoursquareUser user,
            @JsonProperty("visibility") String visibility) {
    }

    @JsonProperty("source")
    PhotoSource source;

    @JsonProperty("venue")
    Venue venue;

    @JsonProperty("tip")
    Tip tip;
}
