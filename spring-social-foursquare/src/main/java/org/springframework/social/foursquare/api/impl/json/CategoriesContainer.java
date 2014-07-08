package org.springframework.social.foursquare.api.impl.json;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Category;

@JsonDeserialize(using=CategoriesContainerDeserializer.class)
public class CategoriesContainer {
	
	private List<Category> categories;
	
	public CategoriesContainer(List<Category> categories) {
		this.categories = categories;
	}

	public List<Category> getCategories() {
		return categories;
	}
}
