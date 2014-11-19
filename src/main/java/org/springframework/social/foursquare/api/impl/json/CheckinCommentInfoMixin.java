package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.foursquare.api.CheckinComment;

import java.util.List;

abstract class CheckinCommentInfoMixin {
    @JsonCreator
    CheckinCommentInfoMixin(
            @JsonProperty("count") int count,
            @JsonProperty("items") List<CheckinComment> comments) {
    }
}
