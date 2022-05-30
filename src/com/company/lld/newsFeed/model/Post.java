package com.company.lld.newsFeed.model;



import java.util.Date;
import java.util.List;

public class Post {
    private String text;
    private int id;
    private Date createdAt;
    private User createdBy;
    private int like;
    private int dislike;
    private List<String> comments;
    private int score;

    public Post() {
    }

    public Post(String text, int id, Date createdAt, User createdBy, int like, int dislike, List<String> comments, int score) {
        this.text = text;
        this.id = id;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.like = like;
        this.dislike = dislike;
        this.comments = comments;
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
