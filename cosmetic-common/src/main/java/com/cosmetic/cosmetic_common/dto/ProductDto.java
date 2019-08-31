package com.cosmetic.cosmetic_common.dto;

import java.util.List;

public class ProductDto extends CommonDto {

    /**
     * 
     */
    private static final long serialVersionUID = -3995163460964223764L;
    private String id;
    private String code;
    private String name;
    private String description;
    private List<String> images;
    private CosmeticMasterDto category;
    private CosmeticMasterDto company;
    private List<String> tags;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getImages() {
        return images;
    }
    public void setImages(List<String> images) {
        this.images = images;
    }
    public CosmeticMasterDto getCategory() {
        return category;
    }
    public void setCategory(CosmeticMasterDto category) {
        this.category = category;
    }
    public CosmeticMasterDto getCompany() {
        return company;
    }
    public void setCompany(CosmeticMasterDto company) {
        this.company = company;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    
}
