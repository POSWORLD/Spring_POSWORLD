package com.posco.posworld.photo.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.service.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("photo")
@TokenRequired
public class PhotoController {
    @Autowired
    PhotoDto photoDto;
    @Autowired
    PhotoServiceImpl photoService;
    @Autowired
    SecurityService securityService;

    @PostMapping("/")
    public Integer postPhoto(@RequestBody PhotoDto photoDto) {
        photoDto.setUserId(securityService.getIdAtToken());
        return photoService.postPhoto(photoDto);
    }

    @PutMapping("/{id}")
    public Integer updatePhoto(@RequestBody PhotoDto photoDto, @PathVariable String id) {
        photoDto.setUserId(securityService.getIdAtToken());
        photoDto.setId(Integer.valueOf(id));
        return photoService.updatePhoto(photoDto);
    }

    @DeleteMapping("/{id}")
    public Integer deletePhoto(@PathVariable String id) {
        photoDto.setUserId(securityService.getIdAtToken());
        photoDto.setId(Integer.valueOf(id));
        return photoService.deletePhoto(photoDto);
    }

    @GetMapping("/{id}")
    public List<PhotoDto> selectPhoto(@PathVariable String id){
        photoDto.setUserId(securityService.getIdAtToken());
        return photoService.selectPhoto(photoDto);
    }
}