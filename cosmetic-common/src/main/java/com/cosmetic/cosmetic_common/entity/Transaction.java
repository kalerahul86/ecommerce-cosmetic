package com.cosmetic.cosmetic_common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column(name = "type")
    private String type;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "businessPoint")
    private String businessPoint;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer")
    private User buyer;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product")
    private Product product;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catelog", referencedColumnName = "code")
    private CosmeticMaster catelog;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getBusinessPoint() {
        return businessPoint;
    }
    public void setBusinessPoint(String businessPoint) {
        this.businessPoint = businessPoint;
    }
    public User getBuyer() {
        return buyer;
    }
    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public CosmeticMaster getCatelog() {
        return catelog;
    }
    public void setCatelog(CosmeticMaster catelog) {
        this.catelog = catelog;
    }
    
}
