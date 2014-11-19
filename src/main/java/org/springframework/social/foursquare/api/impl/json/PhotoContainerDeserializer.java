package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Photo;

import java.io.IOException;

public class PhotoContainerDeserializer extends AbstractFoursquareDeserializer<PhotoContainer> {
    @Override
    public PhotoContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new PhotoContainer(deserializeNestedResponseObject(jp, "photo", Photo.class));
    }
}
