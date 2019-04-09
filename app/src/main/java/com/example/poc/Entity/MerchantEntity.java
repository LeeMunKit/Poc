package com.example.poc.Entity;

import android.net.Uri;
import android.widget.CheckBox;

import com.google.firebase.database.DatabaseReference;

public class MerchantEntity {
    private String compName, compEmail, regNo, compAddr, postcode, state, summary, uid;


    public MerchantEntity(String compName, String compEmail, String regNo, String compAddr, String postcode, String state, String summary, String uid){
        this.compName = compName;
        this.compEmail = compEmail;
        this.regNo = regNo;
        this.compAddr = compAddr;
        this.postcode = postcode;
        this.state = state;
        this.summary = summary;
        this.uid = uid;
    }

    public static void LogFirebase(DatabaseReference ref, String compName, String compEmail, String regNo, String compAddr, String postcode, String state, String summary, String uid){
        MerchantEntity merchant = new MerchantEntity(compName, compEmail, regNo, compAddr, postcode, state, summary, uid);
        ref.child(uid).child("Registration").setValue(merchant);
    }

    public String getCompName() {
        return compName;
    }

    public String getCompEmail() {
        return compEmail;
    }

    public String getRegNo() {
        return regNo;
    }

    public String getCompAddr() {
        return compAddr;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getState() {
        return state;
    }

    public String getSummary() {
        return summary;
    }

    public String getUid() {
        return uid;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setCompAddr(String compAddr) {
        this.compAddr = compAddr;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
