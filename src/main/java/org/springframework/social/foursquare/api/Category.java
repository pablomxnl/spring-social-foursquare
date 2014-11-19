package org.springframework.social.foursquare.api;

import java.util.List;

public class Category {

    private String id;
    private String name;
    private String shortName;
    private String pluralName;
    private Icon icon;
    private List<String> parents;
    private List<Category> children;
    private boolean primary;

    public Category(String id, String name, String shortName, String pluralName, Icon icon, boolean primary) {
        this.id = id;
        this.name = name;
        this.pluralName = pluralName;
        this.icon = icon;
        this.shortName = shortName;
        this.primary = primary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPluralName() {
        return pluralName;
    }


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPluralName(String pluralName) {
        this.pluralName = pluralName;
    }

    public void setParents(List<String> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public List<String> getParents() {
        return parents;
    }

    public List<Category> getChildren() {
        return children;
    }

    public boolean isPrimary() {
        return primary;
    }

}
