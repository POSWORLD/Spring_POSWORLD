package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;

import java.util.List;

public interface PhotoService {
    List<PhotoDto> getPhotoByUserId(PhotoDto photoDto);
    Integer insertPhoto(PhotoDto photoDto);
}
