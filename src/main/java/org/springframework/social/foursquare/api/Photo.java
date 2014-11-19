package org.springframework.social.foursquare.api;

import java.util.Date;

public class Photo {

    private String id;
    private Date createdAt;
    private String url;
    private PhotoSizes sizes;
    private PhotoSource source;
    private FoursquareUser user;
    private Venue venue;
    private String prefix;
    private String suffix;
    private int width;
    private int height;
    private String visibility;

    // public Photo(String id, Date createdAt, String url, PhotoSizes sizes,
    // FoursquareUser user) {
    // this.id = id;
    // this.createdAt = createdAt;
    // this.url = url;
    // this.sizes = sizes;
    // this.user = user;
    // }

    public Photo(String id, Date createdAt, String prefix, String suffix,
                 int width, int height, PhotoSizes sizes, FoursquareUser user,
                 String visibility) {
        this.id = id;
        this.createdAt = createdAt;
        this.prefix = prefix;
        this.suffix = suffix;
        this.url = prefix + width + "x" + height + suffix;
        this.sizes = sizes;
        this.user = user;
        this.width = width;
        this.height = height;
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getUrl() {
        return url;
    }

    public PhotoSizes getSizes() {
        return sizes;
    }

    public PhotoSource getSource() {
        return source;
    }

    public FoursquareUser getUser() {
        return user;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSizes(PhotoSizes sizes) {
        this.sizes = sizes;
    }

    public void setSource(PhotoSource source) {
        this.source = source;
    }

    public void setUser(FoursquareUser user) {
        this.user = user;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

}
