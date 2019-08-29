package com.cosmetic.cosmetic_common.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3995163460964223764L;
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @ElementCollection
    private List<String> images;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(referencedColumnName = "code", name = "category")
    private CosmeticMaster category;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(referencedColumnName = "code", name = "company")
    private CosmeticMaster company;
    @ElementCollection
    @CollectionTable(joinColumns = {
            @JoinColumn(name = "product_id", referencedColumnName = "id")
    })
    @Column(name = "tag_code")
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

    public CosmeticMaster getCategory() {
        return category;
    }

    public void setCategory(CosmeticMaster category) {
        this.category = category;
    }

    public CosmeticMaster getCompany() {
        return company;
    }

    public void setCompany(CosmeticMaster company) {
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
