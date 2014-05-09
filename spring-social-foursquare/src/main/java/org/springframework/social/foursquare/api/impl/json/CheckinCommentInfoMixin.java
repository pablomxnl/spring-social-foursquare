package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.CheckinComment;

abstract class CheckinCommentInfoMixin {
	@JsonCreator
	CheckinCommentInfoMixin(
			@JsonProperty("count") int count,
			@JsonProperty("items") List<CheckinComment> comments) {}
}
