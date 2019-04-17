package com.example.poc.Entity;


import com.google.firebase.database.DatabaseReference;

public class service_Info {
    private String userid,serviceID, eqType, nationality, status,addressInfo;
    private String NoOfPax, reqDate, jobTitle;
    private String furtherStatus;


    public service_Info(){

    }

    public service_Info(String userid, String serviceID, String eqType, String nationality, String status, String NoOfPax,String addressInfo, String reqDate, String jobTtitle, String furtherStatus){
        this.userid = userid;
        this.serviceID = serviceID;
        this.eqType = eqType;
        this.nationality = nationality;
        this.status = status;
        this.NoOfPax = NoOfPax;;
        this.addressInfo = addressInfo;
        this.reqDate = reqDate;
        this.jobTitle = jobTtitle;
        this.furtherStatus =furtherStatus;
    }

    public static void LogFirebase(DatabaseReference serviceRef, DatabaseReference userRef, String userId, String eqType, String nationality,String status, String NoOfPax,String addressInfo, String reqDate, String jobTitle,String furtherStatus) {
        String key = serviceRef.push().getKey();
        service_Info service_info = new service_Info(userId, key, eqType, nationality, status,NoOfPax,addressInfo, reqDate, jobTitle,furtherStatus);
        serviceRef.child(userId).child(key).setValue(service_info);
        userRef.child(userId).child("Services").child(key).setValue(service_info);
    }

    public String getUserid() {
        return userid;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getEqType() {
        return eqType;
    }

    public String getNationality() {
        return nationality;
    }

    public String getNoOfPax() {
        return NoOfPax;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setEqType(String eqType) {
        this.eqType = eqType;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setNoOfPax(String noOfPax) {
        NoOfPax = noOfPax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFurtherStatus() {
        return furtherStatus;
    }

    public void setFurtherStatus(String furtherStatus) {
        this.furtherStatus = furtherStatus;
    }
}
