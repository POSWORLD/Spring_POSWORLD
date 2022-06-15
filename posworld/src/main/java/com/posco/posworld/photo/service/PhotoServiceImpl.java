package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.repository.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoMapper photoMapper;

    @Override
    public Integer postPhoto(PhotoDto photoDto) {
        return photoMapper.insertPhoto(photoDto);
    }

    @Override
    public Integer updatePhoto(PhotoDto photoDto) {
        return photoMapper.updatePhoto(photoDto);
    }

    @Override
    public Integer deletePhoto(PhotoDto photoDto) {
        return photoMapper.deletePhoto(photoDto);

    }
}
