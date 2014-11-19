package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.social.foursquare.api.Category;

import java.util.List;

@JsonDeserialize(using = CategoriesContainerDeserializer.class)
public class CategoriesContainer {

    private List<Category> categories;

    public CategoriesContainer(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
