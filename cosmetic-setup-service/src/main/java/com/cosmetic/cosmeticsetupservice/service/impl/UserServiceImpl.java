package com.cosmetic.cosmeticsetupservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cosmetic.cosmetic_common.dto.UserDto;
import com.cosmetic.cosmetic_common.entity.User;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmetic_common.utility.CacheNames;
import com.cosmetic.cosmeticsetupservice.repository.UserRepository;
import com.cosmetic.cosmeticsetupservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    @Cacheable(cacheNames = CacheNames.USER_MASTER, key = "#id")
    public UserDto get(String id) throws CosmeticException {
        
        logger.info("Getting User.....");
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @CacheEvict(cacheNames = CacheNames.USER_MASTER, allEntries = true)
    public UserDto add(UserDto userDto) throws CosmeticException {
        
        logger.info("Adding User....");
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @CacheEvict(cacheNames = CacheNames.USER_MASTER, allEntries = true)
    public UserDto update(UserDto userDto) throws CosmeticException {
        
        logger.info("Updating User....");
        User user = userRepository.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

	@Override
	@Cacheable(cacheNames = CacheNames.USER_MASTER)
	public List<UserDto> getAllUsers() {
		
		logger.info("Getting all user....");
		List<User> users = userRepository.findAll();
		return modelMapper.map(users,  new TypeToken<List<UserDto>>() {}.getType());
	}

}
