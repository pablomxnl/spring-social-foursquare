package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.VenueLinks;

@JsonDeserialize(using = VenueLinksContainerDeserializer.class)
public class VenueLinksContainer {
    private VenueLinks links;

    public VenueLinksContainer(VenueLinks links) {
        this.links = links;
    }

    public VenueLinks getLinks() {
        return links;
    }
}
