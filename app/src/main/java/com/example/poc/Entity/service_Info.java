package com.example.poc.Entity;

public class service_Info {

    private String userid,serviceID,eqtype,nationality,status,addressInfo;
    private String NoOfPax, reqDate, jobTitle;
    private String furtherStatus;

    public service_Info(){

    }

    public service_Info(String userid, String serviceID, String eqtype, String nationality,
                        String status, String addressInfo, String NoOfPax, String reqDate,
                        String jobTitle, String furtherStatus){
        this.userid = userid;
        this.serviceID = serviceID;
        this.eqtype = eqtype;
        this.nationality = nationality;
        this.status = status;
        this.NoOfPax = NoOfPax;;
        this.addressInfo = addressInfo;
        this.reqDate = reqDate;
        this.jobTitle = jobTitle;
        this.furtherStatus =furtherStatus;

    }

    public String getUserid() {
        return userid;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getEqtype() {
        return eqtype;
    }

    public String getNationality() {
        return nationality;
    }

    public String getStatus() {
        return status;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public String getNoOfPax() {
        return NoOfPax;
    }

    public String getReqDate() {
        return reqDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getFurtherStatus() {
        return furtherStatus;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public void setEqtype(String eqtype) {
        this.eqtype = eqtype;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public void setNoOfPax(String noOfPax) {
        NoOfPax = noOfPax;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setFurtherStatus(String furtherStatus) {
        this.furtherStatus = furtherStatus;
    }
}