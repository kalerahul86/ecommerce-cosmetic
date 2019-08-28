package com.cosmetic.cosmeticsetupservice.service;

import java.util.List;

import com.cosmetic.cosmetic_common.dto.CosmeticMasterDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;

public interface CosmeticMasterService {

   /**
    * Return complete setup, uses cache
    * 
    * @return
    * @throws CosmeticException
    */
    List<CosmeticMasterDto> getSetup() throws CosmeticException;
    
    /**
     * Return list of all settings for specified type
     * 
     * @param type
     * @return
     * @throws CosmeticException
     */
    List<CosmeticMasterDto> getSettingsForType(String type) throws CosmeticException;
    
    void refreshCache();
}
