package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Category;

import java.io.IOException;
import java.util.List;

public class CategoriesContainerDeserializer extends AbstractFoursquareDeserializer<CategoriesContainer> {
    @SuppressWarnings("unchecked")
    @Override
    public CategoriesContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new CategoriesContainer((List<Category>) deserializeNestedList(jp, "categories", new TypeReference<List<Category>>() {
        }));
    }
}
