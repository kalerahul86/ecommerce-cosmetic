package com.cosmetic.cosmeticsetupservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cosmetic.cosmetic_common.dto.UserDto;
import com.cosmetic.cosmetic_common.exception.CosmeticException;
import com.cosmetic.cosmeticsetupservice.service.UserService;

@RestController
@RequestMapping(path = "/user/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(method = RequestMethod.POST)
    public void add(@RequestBody UserDto userDto) throws CosmeticException {
        userService.add(userDto);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody UserDto userDto) throws CosmeticException {
        userService.update(userDto);
    }
    
    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public UserDto get(@PathVariable("id") String id) throws CosmeticException {
        return userService.get(id);
    }
}
