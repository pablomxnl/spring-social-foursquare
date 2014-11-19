package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendMixin {
    @JsonCreator
    FriendMixin(
            @JsonProperty("id") long id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("photoUrl") String photoUrl,
            @JsonProperty("gender") String gender,
            @JsonProperty("homeCity") String homeCity,
            @JsonProperty("relationship") String relationship) {
    }
}
