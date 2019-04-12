package com.example.poc.Entity;

public class JobInfo1 {

    private String Date1;
    private String JobName1;
    private String Location1;
    private String NoOfGuard1;
    private String Status1;
    private String Type1;

    public JobInfo1(){

    }

    public JobInfo1(String date1, String jobName1, String location1, String noOfGuard1, String status1, String type1){
        Date1 = date1;
        JobName1 = jobName1;
        Location1 = location1;
        NoOfGuard1 = noOfGuard1;
        Status1 = status1;
        Type1 = type1;

    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String date1) {
        Date1 = date1;
    }

    public String getJobName1() {
        return JobName1;
    }

    public void setJobName1(String jobName1) {
        JobName1 = jobName1;
    }

    public String getLocation1() {
        return Location1;
    }

    public void setLocation1(String location1) {
        Location1 = location1;
    }

    public String getNoOfGuard1() {
        return NoOfGuard1;
    }

    public void setNoOfGuard1(String noOfGuard1) {
        NoOfGuard1 = noOfGuard1;
    }

    public String getStatus1() {
        return Status1;
    }

    public void setStatus1(String status1) {
        Status1 = status1;
    }

    public String getType1() {
        return Type1;
    }

    public void setType1(String type1) {
        Type1 = type1;
    }


}