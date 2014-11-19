package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Checkin;

import java.util.List;

@JsonDeserialize(using = CheckinListContainerDeserializer.class)
public class CheckinListContainer {

    private List<Checkin> checkins;

    public CheckinListContainer(List<Checkin> checkins) {
        this.checkins = checkins;
    }

    public List<Checkin> getCheckins() {
        return checkins;
    }
}
