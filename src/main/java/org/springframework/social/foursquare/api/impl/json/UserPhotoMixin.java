package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * User: diesel
 * Date: 18/12/13
 * Time: 00:26
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPhotoMixin {
    @JsonCreator
    public UserPhotoMixin(@JsonProperty("prefix") String prefix,
                          @JsonProperty("suffix") String suffix) {
    }
}
