package org.springframework.social.foursquare.api.impl.json;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = StringValueContainerDeserializer.class)
public class StringValueContainer {
    private String value;

    public StringValueContainer(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
