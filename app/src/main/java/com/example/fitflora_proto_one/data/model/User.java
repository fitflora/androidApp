package com.example.fitflora_proto_one.data.model;

import java.util.List;

public class User {

    private List<SessionTree> sessions;
    private String userId;
    private String email;
    private List<Tree> treesFollowing;
    private int level;
    private int userPoints;

    private String currentLocation;

    public User(List<SessionTree> sessions, String userId, String email, List<Tree> treesFollowing, int level, int userPoints, String currentLocation) {
        this.sessions = sessions;
        this.userId = userId;
        this.email = email;
        this.treesFollowing = treesFollowing;
        this.level = level;
        this.userPoints = userPoints;
        this.currentLocation = currentLocation;

    }

    // Getters and Setters

    public String getLocation(){
        return currentLocation;
    }
    public void setLocation(String newLocation){
        this.currentLocation = newLocation;
    }

    public List<SessionTree> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionTree> sessions) {
        this.sessions = sessions;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tree> getTreesFollowing() {
        return treesFollowing;
    }

    public void setTreesFollowing(List<Tree> treesFollowing) {
        this.treesFollowing = treesFollowing;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUserPoints() {
        return userPoints;
    }

    public void setUserPoints(int userPoints) {
        this.userPoints = userPoints;
    }
}