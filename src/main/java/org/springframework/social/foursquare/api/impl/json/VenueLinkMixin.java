package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Provider;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VenueLinkMixin {
    @JsonCreator
    VenueLinkMixin(
            @JsonProperty("provider") Provider provider,
            @JsonProperty("linkedId") String linkedId,
            @JsonProperty("url") String url) {
    }
}
