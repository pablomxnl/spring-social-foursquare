package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.BadgeGroup;
import org.springframework.social.foursquare.api.BadgeImage;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class BadgeGroupMixin {
    @JsonCreator
    BadgeGroupMixin(
            @JsonProperty("type") String type,
            @JsonProperty("name") String name, 
            @JsonProperty("items") List<String> items, 
            @JsonProperty("groups") List<BadgeGroup> groups){}
    
    @JsonProperty("image")
    BadgeImage image;
}
