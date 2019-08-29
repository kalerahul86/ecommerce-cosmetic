package com.cosmetic.cosmetic_common.dto;

public class CosmeticMasterDto extends CommonDto {

    private static final long serialVersionUID = 1925337608424428807L;
    
    private String type;
    private String code;
    private String value;
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    
}
