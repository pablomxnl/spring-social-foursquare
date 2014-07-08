package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
abstract class ContactInfoMixin {
	@JsonCreator
	ContactInfoMixin(
			@JsonProperty("email") String email,
			@JsonProperty("twitter") String twitter,
			@JsonProperty("phone") String phone,
			@JsonProperty("formattedPhone") String formattedPhone) {}

}
