package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.*;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class VenueMixin {
    @JsonCreator
    VenueMixin(
            @JsonProperty("id") String id,
            @JsonProperty("name") String name,
            @JsonProperty("contact") ContactInfo contactInfo,
            @JsonProperty("location") Location location,
            @JsonProperty("categories") List<Category> categories,
            @JsonProperty("verified") boolean verified,
            @JsonProperty("stats") VenueStats stats) {
    }

    @JsonProperty("url")
    String url;

    @JsonProperty("hereNow")
    HereNow hereNow;

    @JsonProperty("tips")
    VenueTips tips;

    @JsonProperty("tags")
    List<String> tags;

    @JsonProperty("specials")
    List<Special> specials;

    @JsonProperty("specialsNearby")
    List<Special> specialsNearby;

    @JsonProperty("shortUrl")
    String shortUrl;

    @JsonProperty("timezone")
    String timezone;

    @JsonProperty("beenHere")
    Map<String, Integer> beenHere;

    @JsonProperty("photos")
    PhotoGroups photos;

    @JsonProperty("description")
    String description;
}
