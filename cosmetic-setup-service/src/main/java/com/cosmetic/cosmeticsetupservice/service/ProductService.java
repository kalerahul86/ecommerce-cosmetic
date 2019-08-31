package com.cosmetic.cosmeticsetupservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.cosmetic.cosmetic_common.dto.ProductDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;

public interface ProductService {

    /**
     * Add product to repository
     * 
     * @param product
     * @param imageFiles 
     * @return
     * @throws CosmeticException
     */
    ProductDto add(ProductDto productDto, List<MultipartFile> imageFiles) throws CosmeticException ;
    
    /**
     * Update product details.
     * Delete older images and write new one
     * 
     * @param product
     * @param imageFiles 
     * @return
     * @throws CosmeticException
     */
    ProductDto update(ProductDto productDto, List<MultipartFile> imageFiles) throws CosmeticException ;
    
    /**
     * Delete product
     * 
     * @param id
     * @return
     * @throws CosmeticException
     */
    boolean delete(String id) throws CosmeticException ;
    
    
    /**
     * Get all products
     * 
     * @return
     * @throws CosmeticException
     */
    List<ProductDto> getAll() throws CosmeticException ;
    
    /**
     * Get Product for specified code
     * 
     * @param productcode
     * @return
     * @throws CosmeticException
     */
    ProductDto getByCode(String productcode) throws CosmeticException;
    
    /**
     * Get Product by Id
     * 
     * @param id
     * @return
     * @throws CosmeticException
     */
    ProductDto get(String id) throws CosmeticException;

    /**
     * Download image
     * 
     * @param image
     * @return
     * @throws CosmeticException
     */
    byte[] download(String image) throws CosmeticException;

    /**
     * Search Products using name can be used for suggestion
     * 
     * @param productName
     * @return
     */
	List<ProductDto> searchProducts(String productName);
}
