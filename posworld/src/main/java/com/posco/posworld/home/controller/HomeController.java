package com.posco.posworld.home.controller;

import com.posco.posworld.user.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.home.model.HomeDto;

import com.posco.posworld.home.service.HomeServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;


@RestController
@RequestMapping("/home")
@TokenRequired
public class HomeController {
    @Autowired
    HomeServiceImpl homeService;
    @Autowired
    SecurityService securityService;

    @GetMapping("/{id}")
    public HomeDto getHome(@PathVariable String id){
        return homeService.getHome(Integer.parseInt(id));

    }
    @PostMapping("/")
    public Integer InsertHome(@RequestBody HomeDto homeDto){
        HomeDto result = null;
        try{
            homeDto.setUserid(homeDto.getUserid());
            homeDto.setTitle("미니룸");
            homeDto.setPhoto("좋은사진");
            homeDto.setContent("좋은주말");
            homeDto.setBgm("좋은음악");

            result = homeService.insertHome(homeDto);
        }catch (Exception e){

        }
        if(result != null){
            return 1;
        }
        return 0;
    }

    @PutMapping("/content/{id}")
    public Integer updateContent(@RequestBody HomeDto homeDto, @PathVariable String id) {
        homeDto.setId(Integer.valueOf(id));
        if( homeService.updateHomeContent(homeDto)!=null){
            return 1;
        }else{
            return 0;
        }
    }

    @PutMapping("/photo/{id}")
    public Integer updatePhoto(@RequestBody HomeDto homeDto, @PathVariable String id) {
        homeDto.setId(Integer.valueOf(id));
        if( homeService.updateHomePhoto(homeDto)!=null){
            return 1;
        }else{
            return 0;
        }
    }

}