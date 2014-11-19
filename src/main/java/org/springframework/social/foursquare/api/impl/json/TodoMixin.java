package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Tip;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TodoMixin {
    @JsonCreator
    TodoMixin(
            @JsonProperty("id") String id,
            @JsonProperty("createdAt") @JsonDeserialize(using = FoursquareDateDeserializer.class) Date createdAt,
            @JsonProperty("tip") Tip tip) {
    }

}
