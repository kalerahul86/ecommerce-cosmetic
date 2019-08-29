package com.cosmetic.cosmetic_common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cosmetic_master")
public class CosmeticMaster {

    @Column(name = "type")
    private String type;
    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "value")
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
