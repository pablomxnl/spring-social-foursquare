package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Special;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class SpecialsMixin {
	@JsonCreator
	SpecialsMixin(
			@JsonProperty("count") int count,
			@JsonProperty("items") List<Special> items){}
}
