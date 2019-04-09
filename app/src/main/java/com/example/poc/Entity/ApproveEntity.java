package com.example.poc.Entity;

import android.content.Intent;

import com.google.firebase.database.DatabaseReference;

public class ApproveEntity {
    private String userID;
    private String statusID;
    private Integer status;

    public ApproveEntity(String userId, String statusID, Integer status) {
        this.userID = userId;
        this.statusID = statusID;
        this.status = status;
    }
    public static void LogFirebase(DatabaseReference approveRef, DatabaseReference MerchantEntityRef, String userId, Integer status) {
        String key = approveRef.push().getKey();
        ApproveEntity approveEntity = new ApproveEntity(userId, key, status);
        approveRef.child(userId).child(key).setValue(approveEntity);
        MerchantEntityRef.child(userId).child("Approval").child(key).setValue(approveEntity);
    }
    public String getUserID() {
        return userID;
    }
    public Integer getStatus() {
        return status;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}