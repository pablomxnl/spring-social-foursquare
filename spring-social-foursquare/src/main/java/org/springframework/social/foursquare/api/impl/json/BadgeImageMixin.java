package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BadgeImageMixin {
    @JsonCreator
    BadgeImageMixin(
            @JsonProperty("prefix") String prefix,
            @JsonProperty("name") String name,
            @JsonProperty("sizes") List<Integer> sizes){}
}
