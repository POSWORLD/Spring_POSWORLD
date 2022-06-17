package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;

public interface PhotoService {
    PhotoDto postPhoto(PhotoDto photoDto);
    PhotoDto updatePhoto(PhotoDto photoDto);
    void deletePhoto(int id);
    PhotoDto getPhotoOne(int id);
}
