package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.FoursquareUser;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class FriendsMixin {
	@JsonCreator
	FriendsMixin(
			@JsonProperty("count") int count,
			@JsonProperty("items") List<FoursquareUser> items){}

}
