package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Photos;

@JsonDeserialize(using=VenuePhotosContainerDeserializer.class)
public class VenuePhotosContainer {
	
	private Photos photos;
	
	public VenuePhotosContainer(Photos photos) {
		this.photos = photos;
	}

	public Photos getPhotos() {
		return photos;
	}
	
}
