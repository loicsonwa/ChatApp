package com.example.chatapp.models;

public class UserModel {
    private String uid, firstName, lastName, bio;
    private double birthDay;
    private boolean gender;
    
    public UserModel() {
        birthDay = 0;
        gender = true;
    }
    
    public String getUid() {
        return uid;
    }
    
    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getBio() {
        return bio;
    }
    
    public void setBio(String bio) {
        this.bio = bio;
    }
    
    public double getBirthDay() {
        return birthDay;
    }
    
    public void setBirthDay(double birthDay) {
        this.birthDay = birthDay;
    }
    
    public boolean isGender() {
        return gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
