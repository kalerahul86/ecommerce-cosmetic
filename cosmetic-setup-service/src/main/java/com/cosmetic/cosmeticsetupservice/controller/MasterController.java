package com.cosmetic.cosmeticsetupservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.cosmetic_common.dto.CosmeticMasterDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmeticsetupservice.service.CosmeticMasterService;

@RestController
@RequestMapping(path = "/master/")
public class MasterController {

    @Autowired
    private CosmeticMasterService cosmeticMasterService;
    
    @RequestMapping(path = "/get", 
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CosmeticMasterDto> getSetup() throws CosmeticException {
        return cosmeticMasterService.getSetup();
    }
    
    @RequestMapping(path = "/get/{type}", 
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CosmeticMasterDto> getSettingsForType(@PathVariable("type") String type) throws CosmeticException {
        return cosmeticMasterService.getSettingsForType(type);
    }
    
    @RequestMapping(path = "/refresh", 
            method = RequestMethod.GET)
    public boolean refreshCache() throws CosmeticException {
        cosmeticMasterService.refreshCache();
        cosmeticMasterService.getSetup();
        return true;
    }
}
