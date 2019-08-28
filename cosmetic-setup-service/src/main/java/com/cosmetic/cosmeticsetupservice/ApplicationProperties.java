package com.cosmetic.cosmeticsetupservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationProperties {

    @Value("${image.filePath}")
    private String imageFilePath;

    public String getImageFilePath() {
        return imageFilePath;
    }
}
