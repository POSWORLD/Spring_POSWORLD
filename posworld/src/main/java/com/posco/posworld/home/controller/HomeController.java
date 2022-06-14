package com.posco.posworld.home.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.home.model.HomeDto;
import com.posco.posworld.home.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return homeService.InsertHome(homeDto);
    }
    @PutMapping("/{id}")
    public Integer updatePost(@RequestBody HomeDto homeDto, @PathVariable String id){
        homeDto.setUserId(securityService.getIdAtToken());
        homeDto.setId(Integer.valueOf(id));
        return homeService.UpdateHome(homeDto);
    }
}
