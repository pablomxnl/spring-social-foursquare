package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.UserSearchResponse;

@JsonDeserialize(using = UserSearchResponseContainerDeserializer.class)
public class UserSearchResponseContainer {

    private UserSearchResponse results;

    public UserSearchResponseContainer(UserSearchResponse results) {
        this.results = results;
    }

    public UserSearchResponse getResults() {
        return results;
    }
}
