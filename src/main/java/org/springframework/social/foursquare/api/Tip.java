package org.springframework.social.foursquare.api;

import java.util.Date;

public class Tip {

    private String id;
    private Date createdAt;
    private String text;
    private String status;
    private Venue venue;
    private FoursquareUser user;
    private TipTodoGroup todo;
    private TipTodoGroup done;

    public Tip(String id, Date createdAt, String text) {
        this.id = id;
        this.createdAt = createdAt;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }

    public Venue getVenue() {
        return venue;
    }

    public FoursquareUser getUser() {
        return user;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setUser(FoursquareUser user) {
        this.user = user;
    }

    public void setTodo(TipTodoGroup todo) {
        this.todo = todo;
    }

    public void setDone(TipTodoGroup done) {
        this.done = done;
    }

    public TipTodoGroup getTodo() {
        return todo;
    }

    public TipTodoGroup getDone() {
        return done;
    }
}
