package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.FoursquareUser;

@JsonDeserialize(using = FoursquareUserContainerDeserializer.class)
public class FoursquareUserContainer {

    private final FoursquareUser user;

    public FoursquareUserContainer(FoursquareUser user) {
        this.user = user;
    }

    public FoursquareUser getUser() {
        return user;
    }

}	
