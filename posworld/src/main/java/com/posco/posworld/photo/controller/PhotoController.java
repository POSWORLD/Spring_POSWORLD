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

    //user 확인 코드는 이후 작성
//    @Autowired
//    SecurityService securityService;

    @PostMapping("/")
    public PhotoDto postPhoto(@RequestBody PhotoDto photoDto) {
        PhotoDto result = null;
        try {
            photoDto.setTitle(photoDto.getTitle());
            photoDto.setImg(photoDto.getImg());
            photoDto.setContent(photoDto.getContent());

            result = photoService.postPhoto(photoDto);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        return result;
    }

    @PutMapping("/{id}")
    public PhotoDto updatePhoto(@RequestBody PhotoDto photoDto, @PathVariable String id) {
//        photoDto.setUserId(securityService.getIdAtToken());
        photoDto.setId(Integer.valueOf(id));
        return photoService.updatePhoto(photoDto);
    }

//    @DeleteMapping("/{id}")
//    public void deletePhoto(@PathVariable String id) {
////        photoDto.setUserId(securityService.getIdAtToken());
//        photoDto.setId(Integer.valueOf(id));
//        photoService.deletePhoto(photoDto.getId());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteBoard(@PathVariable String id) {
        return photoService.deleteBoard(Integer.valueOf(id));
    }
}