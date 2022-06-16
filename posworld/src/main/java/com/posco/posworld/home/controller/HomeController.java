package com.posco.posworld.home.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.home.model.HomeDto;

import com.posco.posworld.home.service.HomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/{id}")
    public HomeDto getHome(@PathVariable String id){
        homeDto.setUserId(Integer.valueOf(id));
        return homeService.getHome(homeDto);
    }

    @PostMapping("/")
    public Integer InsertHome(@RequestBody HomeDto homeDto){

        return homeService.InsertHome(homeDto);
    }
    @PutMapping("/up")
    public Integer updateHome(@RequestBody HomeDto homeDto){
        homeDto.setUserId(securityService.getIdAtToken());
        System.out.println(homeDto);
        return homeService.UpdateHome(homeDto);
    }
}
