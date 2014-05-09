package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.VenueHistory;

@JsonDeserialize(using=VenueHistoryContainerDeserializer.class)
public class VenueHistoryContainer {
	
	private VenueHistory venueHistory;
	
	public VenueHistoryContainer(VenueHistory venueHistory) {
		this.venueHistory = venueHistory;
	}

	public VenueHistory getVenueHistory() {
		return venueHistory;
	}
	
}
