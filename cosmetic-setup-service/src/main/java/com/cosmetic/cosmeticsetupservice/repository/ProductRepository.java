package com.cosmetic.cosmeticsetupservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cosmetic.cosmetic_common.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

    /**
     * Return product for specified product code
     * 
     * @param code
     * @return
     */
    Product findByCode(String code);
}
