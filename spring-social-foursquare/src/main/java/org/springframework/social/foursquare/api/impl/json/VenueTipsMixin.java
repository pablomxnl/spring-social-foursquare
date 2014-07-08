package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.TipGroup;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class VenueTipsMixin {
	@JsonCreator
	VenueTipsMixin(
			@JsonProperty("count") int count,
			@JsonProperty("groups") List<TipGroup> groups) {}
}
