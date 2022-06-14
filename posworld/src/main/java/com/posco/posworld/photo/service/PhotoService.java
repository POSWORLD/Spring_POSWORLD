package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;

public interface PhotoService {
    Integer postPhoto(PhotoDto photoDto);
    Integer updatePhoto(PhotoDto photoDto);
    Integer deletePhoto(PhotoDto photoDto);
}
