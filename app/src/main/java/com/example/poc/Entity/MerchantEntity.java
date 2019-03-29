package com.example.poc.Entity;

import com.google.firebase.database.DatabaseReference;

public class MerchantEntity {
    private String companyName, businessRegNo, mcAdds, mcEmail, uid, AboutDesc;
    private Integer yearEstablish, NoEmployee;

    public MerchantEntity(String companyName, String businessRegNo, String mcAdds, String mcEmail, String uid, String yearEstablish, String aboutDesc, String noEmployee){
    }

    public MerchantEntity(String companyName, String businessRegNo, String mcAdds, String mcEmail, String uid, String AboutDesc, Integer yearEstablish, Integer NoEmployee){
        this.companyName = companyName;
        this.businessRegNo = businessRegNo;
        this.mcAdds = mcAdds;
        this.mcEmail = mcEmail;
        this.uid = uid;

        this.AboutDesc = AboutDesc;
        this.yearEstablish = yearEstablish;
        this.NoEmployee = NoEmployee;
    }

    public static void LogFirebase(DatabaseReference ref, String companyName, String businessRegNo, String mcAdds, String mcEmail, String uid, String yearEstablish, String AboutDesc, String NoEmployee){
        MerchantEntity merchant = new MerchantEntity(companyName, businessRegNo, mcAdds, mcEmail, uid, yearEstablish, AboutDesc, NoEmployee);
        ref.child(uid).child("Registration").setValue(merchant);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBusinessRegNo() {
        return businessRegNo;
    }

    public String getMcAdds() {
        return mcAdds;
    }

    public String getMcEmail() {
        return mcEmail;
    }

    public String getUid() {
        return uid;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBusinessRegNo(String businessRegNo) {
        this.businessRegNo = businessRegNo;
    }

    public void setMcAdds(String mcAdds) {
        this.mcAdds = mcAdds;
    }

    public void setMcEmail(String mcEmail) {
        this.mcEmail = mcEmail;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAboutDesc() {
        return AboutDesc;
    }

    public Integer getYearEstablish() {
        return yearEstablish;
    }

    public Integer getNoEmployee() {
        return NoEmployee;
    }

    public void setAboutDesc(String aboutDesc) {
        AboutDesc = aboutDesc;
    }

    public void setYearEstablish(Integer yearEstablish) {
        this.yearEstablish = yearEstablish;
    }

    public void setNoEmployee(Integer noEmployee) {
        NoEmployee = noEmployee;
    }
}
