package org.springframework.social.foursquare.api.impl;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BadgeCount {

    private int count;

    public BadgeCount(@JsonProperty("count") int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
