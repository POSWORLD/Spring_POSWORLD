package com.posco.posworld.photo.controller;

import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.service.PhotoServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("photo")
//@TokenRequired
public class PhotoController {
    @Autowired
    PhotoDto photoDto;
    @Autowired
    PhotoServiceImpl photoService;

    @PostMapping("/{userid}")
    public ResponseEntity<?> postPhoto(@RequestBody PhotoDto photoDto, @PathVariable String userid) {
        PhotoDto result = null;
        try {
            photoDto.setUserid(Integer.valueOf(userid));
            photoDto.setTitle(photoDto.getTitle());
            photoDto.setImg(photoDto.getImg());
            photoDto.setContent(photoDto.getContent());

            result = photoService.postPhoto(photoDto);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        HttpStatus httpStatus = (result != null )? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }


    @PutMapping("/{id}/{userid}")
    public ResponseEntity<?> updatePhoto(@RequestBody PhotoDto photoDto, @PathVariable String id, @PathVariable String userid) {
        PhotoDto result = null;
        try{
            photoDto.setUserid(Integer.valueOf(userid));
            photoDto.setId(Integer.valueOf(id));
            photoDto.setTitle(photoDto.getTitle());
            photoDto.setImg(photoDto.getImg());
            photoDto.setContent(photoDto.getContent());
            result = photoService.updatePhoto(photoDto);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
        HttpStatus httpStatus = (result != null )? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/{userid}")
    public Integer deletePhoto(@PathVariable String id, @PathVariable String userid) {
        Integer result = null;
        photoDto.setUserid(Integer.valueOf(userid));
        photoDto.setId(Integer.valueOf(id));
        result = photoService.deletePhoto(photoDto);

        return result;
    }

    @GetMapping("/{homeid}")
    public List<PhotoDto> getPhoto(@PathVariable String homeid ){
        photoDto.setUserid(Integer.valueOf(homeid));
        return photoService.getPhotoByUserId(photoDto.getUserid());
    }
    @GetMapping("/detail/{id}")
    public PhotoDto getPhotoById(@PathVariable String id){
        photoDto.setId(Integer.valueOf(id));
        return photoService.getPhotoOne(photoDto.getId());
    }

}