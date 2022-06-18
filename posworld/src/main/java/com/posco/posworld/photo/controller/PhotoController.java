package com.posco.posworld.photo.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.service.PhotoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("photo")
//@TokenRequired
public class PhotoController {
    @Autowired
    PhotoDto photoDto;
    @Autowired
    PhotoServiceImpl photoService;

    @Autowired
    SecurityService securityService;

    @PostMapping("/")
    public Integer postPhoto(@RequestBody PhotoDto photoDto) {
        PhotoDto result = null;
        try {
            photoDto.setTitle(photoDto.getTitle());
            photoDto.setImg(photoDto.getImg());
            photoDto.setContent(photoDto.getContent());

            //result = photoService.postPhoto(photoDto);
            return 1;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            return 0;
        }
    }

    @PutMapping("/{id}")
    public Integer updatePhoto(@RequestBody PhotoDto photoDto, @PathVariable String id) {
        PhotoDto result = null;
        try{
            photoDto.setUserid(securityService.getIdAtToken());
            photoDto.setId(Integer.valueOf(id));
            result = photoService.updatePhoto(photoDto);
            return 1;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            return 0;
        }
    }

    @DeleteMapping("/{id}")
    public Integer deletePhoto(@PathVariable String id) {
        PhotoDto result = null;
        try {
            photoDto.setUserid(securityService.getIdAtToken());
            photoDto.setId(Integer.valueOf(id));
            photoService.deletePhoto(photoDto.getId());
            return 1;
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            return 0;
        }
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Map<String,Boolean>> deleteBoard(@PathVariable String id) {
//        return photoService.deleteBoard(Integer.valueOf(id));
//    }
}