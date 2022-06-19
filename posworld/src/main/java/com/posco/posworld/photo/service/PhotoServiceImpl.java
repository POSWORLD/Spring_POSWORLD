package com.posco.posworld.photo.service;

import com.posco.posworld.board.exception.ResourceNotFoundException;
import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    @Override
    public PhotoDto getPhotoOne(int id) {
        return photoRepository.findById(id);
    }

    @Override
    public List<PhotoDto> getPhotoByUserId(int userid) {
        return photoRepository.findPhotoDtoByUserid(userid);
    }

    @Override
    public PhotoDto postPhoto(PhotoDto photoDto) {
        return photoRepository.save(photoDto);
    }

    @Override
    public PhotoDto updatePhoto(PhotoDto photoDto) {
        return photoRepository.save(photoDto);
    }

    @Override
    public Integer deletePhoto(PhotoDto photoDto) {
        return photoRepository.deleteByIds(photoDto.getId(), photoDto.getUserid());
    }
}