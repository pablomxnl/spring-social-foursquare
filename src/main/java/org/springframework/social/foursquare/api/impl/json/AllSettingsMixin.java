package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AllSettingsMixin {
    @JsonCreator
    AllSettingsMixin(
            @JsonProperty("receivePings") boolean receivePings,
            @JsonProperty("receiveCommentPings") boolean receiveCommentPings,
            @JsonProperty("sendToTwitter") boolean sendToTwitter,
            @JsonProperty("sendMayorshipsToTwitter") boolean sendMayorshipsToTwitter,
            @JsonProperty("sendBadgesToTwitter") boolean sendBadgesToTwitter,
            @JsonProperty("sendToFacebook") boolean sendToFacebook,
            @JsonProperty("sendMayorshipsToFacebook") boolean sendMayorshipsToFacebook,
            @JsonProperty("sendBadgesToFacebook") boolean sendBadgesToFacebook,
            @JsonProperty("foreignConsent") String foreignConsent) {
    }
}
