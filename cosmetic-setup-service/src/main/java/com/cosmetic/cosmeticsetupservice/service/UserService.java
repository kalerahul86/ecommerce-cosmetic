package com.cosmetic.cosmeticsetupservice.service;

import com.cosmetic.cosmetic_common.dto.UserDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;

public interface UserService {

    /**
     * Get User by id
     * 
     * @param id
     * @return
     * @throws CosmeticException
     */
    UserDto get(String id) throws CosmeticException;
    
    /**
     * Add User
     * 
     * @param userDto
     * @return
     * @throws CosmeticException
     */
    UserDto add(UserDto userDto) throws CosmeticException;
    
    
    /**
     * Update User
     * 
     * @param userDto
     * @return
     * @throws CosmeticException
     */
    UserDto update(UserDto userDto) throws CosmeticException;
}
