package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.repository.PhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoDto photoDto;

    @Autowired
    PhotoMapper photoMapper;

    @Override
    public List<PhotoDto> getPhotoByUserId(PhotoDto photoDto) {
        return photoMapper.getPhotoByUserId(photoDto);
    }

    @Override
    public Integer insertPhoto(PhotoDto photoDto) {
        return photoMapper.insertPhoto(photoDto);
    }
}
