package com.cosmetic.cosmetic_common.dto;

public class TransactionDto {

    private String id;
    private String type;
    private double quantity;
    private double totalAmount;
    private UserDto buyer;
    private ProductDto product;
    private String businessPoint;
    private CosmeticMasterDto catelog;
    
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
    public UserDto getBuyer() {
        return buyer;
    }
    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }
    public ProductDto getProduct() {
        return product;
    }
    public void setProduct(ProductDto product) {
        this.product = product;
    }
    public String getBusinessPoint() {
        return businessPoint;
    }
    public void setBusinessPoint(String businessPoint) {
        this.businessPoint = businessPoint;
    }
    public CosmeticMasterDto getCatelog() {
        return catelog;
    }
    public void setCatelog(CosmeticMasterDto catelog) {
        this.catelog = catelog;
    }
    
}
