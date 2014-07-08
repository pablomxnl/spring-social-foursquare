package org.springframework.social.foursquare.api.impl.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.FoursquareUser;
import org.springframework.social.foursquare.api.TipTodoGroup;
import org.springframework.social.foursquare.api.Venue;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class TipMixin {
	@JsonCreator
	TipMixin(
			@JsonProperty("id") String id,
			@JsonProperty("createdAt") @JsonDeserialize(using=FoursquareDateDeserializer.class) Date createdAt,
			@JsonProperty("text") String text){}
	
	@JsonProperty("venue") 
	Venue venue;
	
	@JsonProperty("user") 
	FoursquareUser user;
	
	@JsonProperty("status")
	String status;
	
	@JsonProperty("todo")
	TipTodoGroup todo;
	
	@JsonProperty("done")
	TipTodoGroup done;
}
