package com.veercreation.vinsta.model;

public class NotificationModel {
    String notification;
    String time;
    int profilePic;


    public NotificationModel(int profilePic , String notification, String time) {
        this.notification = notification;
        this.time = time;
        this.profilePic = profilePic;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }
}
