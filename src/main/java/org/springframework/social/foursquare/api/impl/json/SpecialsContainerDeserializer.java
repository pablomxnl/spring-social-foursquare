package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Specials;

import java.io.IOException;

public class SpecialsContainerDeserializer extends AbstractFoursquareDeserializer<SpecialsContainer> {

    @Override
    public SpecialsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new SpecialsContainer(deserializeNestedResponseObject(jp, "specials", Specials.class));
    }
}
