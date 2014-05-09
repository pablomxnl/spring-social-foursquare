package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.VenueGroupItem;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueGroupMixin {
	@JsonCreator
	VenueGroupMixin(
			@JsonProperty("type") String type,
			@JsonProperty("name") String name,
			@JsonProperty("items") List<VenueGroupItem> items){}
}
