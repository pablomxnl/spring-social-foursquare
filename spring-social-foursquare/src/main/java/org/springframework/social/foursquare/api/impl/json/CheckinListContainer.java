package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Checkin;

@JsonDeserialize(using=CheckinListContainerDeserializer.class)
public class CheckinListContainer {
	
	private List<Checkin> checkins;
	
	public CheckinListContainer(List<Checkin> checkins) {
		this.checkins = checkins;
	}
	
	public List<Checkin> getCheckins() {
		return checkins;
	}
}
