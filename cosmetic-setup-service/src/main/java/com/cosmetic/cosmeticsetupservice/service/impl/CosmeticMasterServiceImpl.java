package com.cosmetic.cosmeticsetupservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cosmetic.cosmetic_common.dto.CosmeticMasterDto;
import com.cosmetic.cosmetic_common.entity.CosmeticMaster;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmetic_common.utility.CacheNames;
import com.cosmetic.cosmeticsetupservice.repository.CosmeticMasterRepository;
import com.cosmetic.cosmeticsetupservice.service.CosmeticMasterService;

@Service
public class CosmeticMasterServiceImpl implements CosmeticMasterService {

    private static Logger logger = LoggerFactory.getLogger(CosmeticMasterServiceImpl.class);
    
    @Autowired
    private CosmeticMasterRepository masterRepo;
    
    @Override
    @Cacheable(cacheNames = CacheNames.COSMETIC_MASTER)
    public List<CosmeticMasterDto> getSetup() throws CosmeticException {
        
        logger.info("Getting complete setup...");
        List<CosmeticMaster> setup = masterRepo.findAll();
        return new ModelMapper().map(setup, new TypeToken<List<CosmeticMasterDto>>() {}.getType());
    }

    @Override
    @CacheEvict(cacheNames = CacheNames.COSMETIC_MASTER, allEntries = true)
    public void refreshCache() {
       
    }

    @Override
    public List<CosmeticMasterDto> getSettingsForType(String type) throws CosmeticException {
        
        List<CosmeticMasterDto> settings = getSetup();
        return settings.stream().filter((setting) ->  setting.getType().equals(type)).collect(Collectors.toList());
    }

}
