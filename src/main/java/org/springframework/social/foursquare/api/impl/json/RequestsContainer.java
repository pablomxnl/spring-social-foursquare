package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.FoursquareUser;

import java.util.List;

@JsonDeserialize(using = RequestsContainerDeserializer.class)
public class RequestsContainer {

    private List<FoursquareUser> requests;

    public RequestsContainer(List<FoursquareUser> requests) {
        this.requests = requests;
    }

    public List<FoursquareUser> getRequests() {
        return requests;
    }
}
