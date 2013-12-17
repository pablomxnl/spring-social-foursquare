package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Tip;

@JsonDeserialize(using=TipContainerDeserializer.class)
public class TipContainer {
	private Tip tip;
	
	public TipContainer(Tip tip) {
		this.tip = tip;
	}
	
	public Tip getTip() {
		return tip;
	}
}
