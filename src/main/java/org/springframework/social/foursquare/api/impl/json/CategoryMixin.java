package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Category;
import org.springframework.social.foursquare.api.Icon;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CategoryMixin {
    @JsonCreator
    CategoryMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("shortName") String shortName,
            @JsonProperty("pluralName") String pluralName,
            @JsonProperty("icon") Icon icon,
            @JsonProperty("primary") boolean primary) {
    }

    @JsonProperty("parents")
    List<String> parents;

    @JsonProperty("categories")
    List<Category> children;
}
