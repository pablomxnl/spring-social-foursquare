package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Todo;

import java.io.IOException;

public class TodoContainerDeserializer extends AbstractFoursquareDeserializer<TodoContainer> {
    @Override
    public TodoContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new TodoContainer(deserializeNestedResponseObject(jp, "todo", Todo.class));
    }
}