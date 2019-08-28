package com.cosmetic.cosmeticsetupservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetic.cosmetic_common.dto.ProductDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmeticsetupservice.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin
@RestController
@RequestMapping(path = "/product/")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductDto> getAll() throws CosmeticException{
        return productService.getAll();
    }
    
    @RequestMapping(path = "/code/{code}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto getByCode(@PathVariable("code") String productCode) throws CosmeticException {
        return productService.getByCode(productCode);
    }
    
    @RequestMapping(path = "{id}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDto get(@PathVariable("id") String id) throws CosmeticException {
        return productService.get(id);
    }
    
    @RequestMapping( 
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public void add(@RequestParam("request") String productDtoString, @RequestPart("images") List<MultipartFile> imageFiles) throws CosmeticException {
        
        ProductDto productDto = getProduct(productDtoString);
        productService.add(productDto, imageFiles);
    }
    
    private ProductDto getProduct(String productDtoString) throws CosmeticException {
        
        ProductDto productDto;
        try {
            productDto = new ObjectMapper().readValue(productDtoString, ProductDto.class);
        } catch (IOException e) {
            throw new CosmeticException(e);
        }
        return productDto;
    }
    
    
    @RequestMapping( 
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.PUT)
    public void update(@RequestParam("request") String productDtoString, @RequestPart("images") List<MultipartFile> imageFiles) throws CosmeticException {
        
        ProductDto productDto = getProduct(productDtoString);
        productService.update(productDto, imageFiles);
    }
    
    @RequestMapping(path = "{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) throws CosmeticException {
        
        productService.delete(id);
    }
    
    @RequestMapping(path = "/download", method = RequestMethod.GET,
            produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] download(@RequestParam("imagename") String image) throws CosmeticException {
        return productService.download(image);
    }
}
