package com.example.chatapp.models;

public class ShipmentModel {
    private String TrackingNum;
    private String Status;
    private int StatusBackground;
    private String TrackingPickupLocation;
    private String TrackingDropLocation;
    private String TrackingPickupDate;
    private String TrackingDropDate;
    
    public ShipmentModel(String trackingNum, String status, int statusBackground, String trackingPickupLocation, String trackingDropLocation, String trackingPickupDate, String trackingDropDate) {
        TrackingNum = trackingNum;
        Status = status;
        StatusBackground = statusBackground;
        TrackingPickupLocation = trackingPickupLocation;
        TrackingDropLocation = trackingDropLocation;
        TrackingPickupDate = trackingPickupDate;
        TrackingDropDate = trackingDropDate;
    }
    
    public String getTrackingNum() {
        return TrackingNum;
    }
    
    public void setTrackingNum(String trackingNum) {
        TrackingNum = trackingNum;
    }
    
    public String getStatus() {
        return Status;
    }
    
    public void setStatus(String status) {
        Status = status;
    }
    
    public int getStatusBackground() {
        return StatusBackground;
    }
    
    public void setStatusBackground(int statusBackground) {
        StatusBackground = statusBackground;
    }
    
    public String getTrackingPickupLocation() {
        return TrackingPickupLocation;
    }
    
    public void setTrackingPickupLocation(String trackingPickupLocation) {
        TrackingPickupLocation = trackingPickupLocation;
    }
    
    public String getTrackingDropLocation() {
        return TrackingDropLocation;
    }
    
    public void setTrackingDropLocation(String trackingDropLocation) {
        TrackingDropLocation = trackingDropLocation;
    }
    
    public String getTrackingPickupDate() {
        return TrackingPickupDate;
    }
    
    public void setTrackingPickupDate(String trackingPickupDate) {
        TrackingPickupDate = trackingPickupDate;
    }
    
    public String getTrackingDropDate() {
        return TrackingDropDate;
    }
    
    public void setTrackingDropDate(String trackingDropDate) {
        TrackingDropDate = trackingDropDate;
    }
}
