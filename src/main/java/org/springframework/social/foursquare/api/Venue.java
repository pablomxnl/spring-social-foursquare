package org.springframework.social.foursquare.api;

import java.util.List;

public class Venue {

    private String id;
    private String name;
    private ContactInfo contactInfo;
    private Location location;
    private List<Category> categories;
    private boolean verified;
    private VenueStats stats;
    private String url;
    private HereNow hereNow;
    private VenueTips tips;
    private List<String> tags;
    private Specials specials;
    private List<Special> specialsNearby;
    private String shortUrl;
    private String timezone;
    private VenueBeenHere beenHere;
    private PhotoGroups photos;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public VenueStats getStats() {
        return stats;
    }

    public void setStats(VenueStats stats) {
        this.stats = stats;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow hereNow) {
        this.hereNow = hereNow;
    }

    public VenueTips getTips() {
        return tips;
    }

    public void setTips(VenueTips tips) {
        this.tips = tips;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Specials getSpecials() {
        return specials;
    }

    public void setSpecials(Specials specials) {
        this.specials = specials;
    }

    public List<Special> getSpecialsNearby() {
        return specialsNearby;
    }

    public void setSpecialsNearby(List<Special> specialsNearby) {
        this.specialsNearby = specialsNearby;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public VenueBeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(VenueBeenHere beenHere) {
        this.beenHere = beenHere;
    }

    public PhotoGroups getPhotos() {
        return photos;
    }

    public void setPhotos(PhotoGroups photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
