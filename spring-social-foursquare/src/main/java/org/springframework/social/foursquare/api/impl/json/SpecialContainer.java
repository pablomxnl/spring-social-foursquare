package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Special;

@JsonDeserialize(using=SpecialContainerDeserializer.class)
public class SpecialContainer {
	private Special special;
	
	public SpecialContainer(Special special) {
		this.special = special;
	}
	
	public Special getSpecial() {
		return special;
	}
}
