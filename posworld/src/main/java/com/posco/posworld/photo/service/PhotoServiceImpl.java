package com.posco.posworld.photo.service;

import com.posco.posworld.photo.model.PhotoDto;
import com.posco.posworld.photo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    PhotoRepository photoRepository;

    @Override
    public PhotoDto getPhotoOne(int id) {
        return photoRepository.findById(id);
    }

    @Override
    public PhotoDto postPhoto(PhotoDto photoDto) {
        return photoRepository.save(photoDto);
    }

    @Override
    public PhotoDto updatePhoto(PhotoDto photoDto) {
        PhotoDto newPhoto = getPhotoOne(photoDto.getId());
        newPhoto.setTitle(photoDto.getTitle());
        newPhoto.setImg(photoDto.getImg());
        newPhoto.setContent(photoDto.getContent());
        return photoRepository.save(newPhoto);
    }

    @Override
    public void deletePhoto(int id) {
        photoRepository.deleteById(id);
    }
}