package com.cosmetic.cosmetic_common.dto;

public class UserDto extends CommonDto {

    private static final long serialVersionUID = 4773488368876546573L;
    
    private String id;
    private String fullName;
    private String mobileNumber;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
}
