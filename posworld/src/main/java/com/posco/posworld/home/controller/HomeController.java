package com.posco.posworld.home.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.home.model.HomeDto;

import com.posco.posworld.home.service.HomeServiceImpl;
import com.posco.posworld.user.model.UserDto;
import com.posco.posworld.user.service.UserServiceImpl;
import io.swagger.models.auth.In;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home")
@TokenRequired
public class HomeController {
    @Autowired
    HomeServiceImpl homeService;
    @Autowired
    SecurityService securityService;
    @Autowired
    HomeDto homeDto;

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserDto userDto;

    @PostMapping("/")
    public Integer InsertHome(@RequestBody HomeDto homeDto){
        return homeService.insertHome(homeDto);
    }
    @PutMapping("/{id}")
    public Integer updateHome(@RequestBody HomeDto homeDto, @PathVariable String id){
        homeDto.setUserId(securityService.getIdAtToken());
        homeDto.setId(Integer.valueOf(id));
        return homeService.updateHome(homeDto);
    }

    @GetMapping("/{id}")
    public HomeDto getHome(@PathVariable String id){
        homeDto.setUserId(Integer.valueOf(id));
        return homeService.getHome(homeDto);

    }

}
