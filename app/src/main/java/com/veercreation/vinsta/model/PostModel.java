package com.veercreation.vinsta.model;

public class PostModel {
    int profile , postPicture , save;
    String username , about , likes , comments , shares;

    public PostModel(int profile, int postPicture, int save, String username, String about, String likes, String comments, String shares) {
        this.profile = profile;
        this.postPicture = postPicture;
        this.save = save;
        this.username = username;
        this.about = about;
        this.likes = likes;
        this.comments = comments;
        this.shares = shares;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public int getPostPicture() {
        return postPicture;
    }

    public void setPostPicture(int postPicture) {
        this.postPicture = postPicture;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getShares() {
        return shares;
    }

    public void setShares(String shares) {
        this.shares = shares;
    }
}
