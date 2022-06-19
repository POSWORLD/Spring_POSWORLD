package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PhotoService {
    PhotoDto postPhoto(PhotoDto photoDto);
    PhotoDto updatePhoto(PhotoDto photoDto);
    Integer deletePhoto(PhotoDto photoDto);
    PhotoDto getPhotoOne(int id);

    List<PhotoDto> getPhotoByUserId(int userid);
}