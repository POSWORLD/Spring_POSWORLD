package com.posco.posworld.home.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.home.model.HomeDto;
import com.posco.posworld.home.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
@TokenRequired
public class HomeController {
    @Autowired
    HomeServiceImpl homeService;
    @Autowired
    SecurityService securityService;
    @Autowired
    HomeDto homeDto;
    @PostMapping("/")
    public Integer InserPost(@RequestBody HomeDto homeDto){
        homeDto.setUserId(securityService.getIdAtToken());
        return homeService.InsertPost(homeDto);
    }
}
