package com.example.poc.Entity;

import com.google.firebase.database.DatabaseReference;

public class aboutEntity {
    private String AboutDesc;
    private Integer yearEstablish, NoEmployee;

    public aboutEntity(){
    }

    public aboutEntity(Integer yearEstablish, String AboutDesc, Integer NoEmployee){
        this.yearEstablish = yearEstablish;
        this.AboutDesc = AboutDesc;
        this.NoEmployee = NoEmployee;

    }

//    public static void LogFirebase(DatabaseReference ref, Integer yearEstablish, String AboutDesc, Integer NoEmployee){
//        aboutEntity aboutUs = new aboutEntity(yearEstablish, AboutDesc, NoEmployee);
//        ref.child(uid).child("CompanyInfo").setValue(aboutUs);
//    }

}
