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
        System.out.println(photoRepository.save(photoDto));
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

//    @Override
//    public ResponseEntity<Map<String, Boolean>> deleteBoard(Integer id){
//        PhotoDto photoDto = photoRepository.findById(id)
//                .orElseThrow(()-> new ResourceNotFoundException("Board not exist with id : "+ id));
//        photoRepository.delete(photoDto);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
}