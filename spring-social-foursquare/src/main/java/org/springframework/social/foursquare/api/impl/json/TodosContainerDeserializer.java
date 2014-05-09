package org.springframework.social.foursquare.api.impl.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Todos;

public class TodosContainerDeserializer extends AbstractFoursquareDeserializer<TodosContainer> {
	@Override
	public TodosContainer deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return new TodosContainer(deserializeNestedResponseObject(jp, "todos", Todos.class));
	}
}
