package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ReasonMixin {
    @JsonCreator
    ReasonMixin(
            @JsonProperty("count") String type,
            @JsonProperty("items") String message){}
}
