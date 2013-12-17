package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.Todo;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class TodosMixin {
	@JsonCreator
	TodosMixin(
			@JsonProperty("count") int count,
			@JsonProperty("items") List<Todo> items){}
}
