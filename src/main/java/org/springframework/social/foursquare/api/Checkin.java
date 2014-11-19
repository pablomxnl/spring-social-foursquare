package org.springframework.social.foursquare.api;

import java.util.Date;

public class Checkin {

    private String id;
    private FoursquareUser user;
    private Date createdAt;
    private String type;
    private String shout;
    private boolean mayor;
    private String timeZone;
    private Venue venue;
    private Photos photos;
    private CheckinSource source;
    private CheckinCommentInfo comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FoursquareUser getUser() {
        return user;
    }

    public void setUser(FoursquareUser user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShout() {
        return shout;
    }

    public void setShout(String shout) {
        this.shout = shout;
    }

    public boolean isMayor() {
        return mayor;
    }

    public void setMayor(boolean mayor) {
        this.mayor = mayor;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public CheckinSource getSource() {
        return source;
    }

    public void setSource(CheckinSource source) {
        this.source = source;
    }

    public CheckinCommentInfo getComments() {
        return comments;
    }

    public void setComments(CheckinCommentInfo comments) {
        this.comments = comments;
    }
}
