package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PhotoService {
    PhotoDto postPhoto(PhotoDto photoDto);
    PhotoDto updatePhoto(PhotoDto photoDto);
    void deletePhoto(int id);
//    ResponseEntity<Map<String, Boolean>> deleteBoard(Integer id);
    PhotoDto getPhotoOne(int id);

}