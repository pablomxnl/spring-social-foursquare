package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.TipUserGroup;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class TipTodoGroupMixin {
	TipTodoGroupMixin(
			@JsonProperty("count") int count,
			@JsonProperty("groups") List<TipUserGroup> groups){}
}
