package com.cosmetic.cosmeticsetupservice.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmeticsetupservice.ApplicationProperties;

@Component
public class FileManager {

    private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
    
    @Autowired
    private ApplicationProperties applicationProperties;
    
    /**
     * Write files to location
     * 
     * @param files
     * @return
     */
    public void writeFiles(List<MultipartFile> files) {
        
        files.stream().forEach((file) -> {
            try {
                writeFile(file);
            } catch (CosmeticException e) {
                logger.error("Error while writting file", e);
            }
        });
    }
    
    /**
     * Read file into bytes
     * 
     * @param image
     * @return
     * @throws CosmeticException
     */
    public byte[] readFile(String fileName) throws CosmeticException {
     
        try (InputStream input = new FileInputStream(applicationProperties.getImageFilePath()+fileName)) {
            byte[] imageByte = new byte[input.available()];
            input.read(imageByte);
            return imageByte;
        } catch (IOException e) {
            logger.error("Error while writing file..", e);
            throw new CosmeticException(e);
        }
    }
    
    /**
     * Write single file
     * 
     * @param file
     * @throws CosmeticException
     */
    public void writeFile(MultipartFile file) throws CosmeticException {
        
        Path filepath = Paths.get(applicationProperties.getImageFilePath(), file.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(filepath)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            logger.error("Error while writing file..", e);
            throw new CosmeticException(e);
        }
    }
    
    /**
     * Delete files
     * 
     * @param images
     */
    public void deleteFiles(List<String> images) {
        
        images.stream().forEach(imageName -> {
            File imageFile = new File(applicationProperties.getImageFilePath()+imageName);
            imageFile.delete();
        });
        
    }
}
