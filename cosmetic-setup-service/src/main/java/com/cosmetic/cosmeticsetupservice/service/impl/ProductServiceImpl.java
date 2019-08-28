package com.cosmetic.cosmeticsetupservice.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetic.cosmetic_common.dto.ProductDto;
import com.cosmetic.cosmetic_common.entity.Product;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmetic_common.utility.CacheNames;
import com.cosmetic.cosmeticsetupservice.Utility.FileManager;
import com.cosmetic.cosmeticsetupservice.repository.ProductRepository;
import com.cosmetic.cosmeticsetupservice.service.ProductService;

@Service
@Transactional(rollbackFor = CosmeticException.class, propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private FileManager fileManager;
    
    @Override
    @CacheEvict(cacheNames = CacheNames.PRODUCT_MASTER, allEntries = true)
    public ProductDto add(ProductDto productDto, List<MultipartFile> imageFiles) throws CosmeticException {
        
        logger.info("Adding product details...");
        List<String> imagesName = imageFiles.parallelStream().map(MultipartFile::getOriginalFilename).collect(Collectors.toList());
        productDto.setImages(imagesName);
        
        Product product = new ModelMapper().map(productDto, Product.class);
        product = productRepository.save(product);
        
        logger.info("Writting file to location");
        fileManager.writeFiles(imageFiles);
        return new ModelMapper().map(product, ProductDto.class);
    }

    @Override
    @CacheEvict(cacheNames = CacheNames.PRODUCT_MASTER, allEntries = true)
    public ProductDto update(ProductDto productDto, List<MultipartFile> imageFiles) throws CosmeticException {
        
        logger.info("Updating product details...");
        ProductDto existingProduct = get(productDto.getId());
        List<String> existingImages = existingProduct.getImages();
        
        //If new files are uploaded
        if(imageFiles !=null && !imageFiles.isEmpty()) {
            List<String> imagesName = imageFiles.parallelStream().map(MultipartFile::getOriginalFilename).collect(Collectors.toList());
            productDto.setImages(imagesName);
        }
        
        Product product = new ModelMapper().map(productDto, Product.class);
        product = productRepository.save(product);
        
        if(imageFiles !=null && !imageFiles.isEmpty()) {
            updateImages(imageFiles, existingImages);
        }
        return new ModelMapper().map(product, ProductDto.class);
    }

    /**
     * Delete existing images and write specified new images
     * 
     * @param files
     * @param images
     */
    private void updateImages(List<MultipartFile> files, List<String> images) {
        
        fileManager.deleteFiles(images);
        fileManager.writeFiles(files);
    }
    
    @Override
    @CacheEvict(cacheNames = CacheNames.PRODUCT_MASTER, allEntries = true)
    public boolean delete(String id) throws CosmeticException {
        
        logger.info("Deleting product...");
        
        List<String> images = productRepository.getOne(id).getImages();
        productRepository.deleteById(id);
        //Delete images
        fileManager.deleteFiles(images);
        return true;
    }

    @Override
    @Cacheable(cacheNames = CacheNames.PRODUCT_MASTER)
    public List<ProductDto> getAll() throws CosmeticException {
        
        logger.info("Getting all product...");
        List<Product> products = productRepository.findAll();
        return new ModelMapper().map(products, new TypeToken<List<ProductDto>>() {}.getType());
    }

    @Override
    @Cacheable(cacheNames = CacheNames.PRODUCT_MASTER, key = "#productcode")
    public ProductDto getByCode(String productcode) throws CosmeticException {
        
       logger.info("Getting product by code...");
       Product product = productRepository.findByCode(productcode);
       return new ModelMapper().map(product, ProductDto.class);
    }

    @Override
    @Cacheable(cacheNames = CacheNames.PRODUCT_MASTER, key = "#id")
    public ProductDto get(String id) throws CosmeticException {
        
        logger.info("Getting product by code...");
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.isPresent()?new ModelMapper().map(productOptional.get(), ProductDto.class):null;
    }

    @Override
    public byte[] download(String image) throws CosmeticException {
        
        logger.info("Reading file...");
        return fileManager.readFile(image);
    }
}
