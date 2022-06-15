package com.posco.posworld.photo.repository;

import com.posco.posworld.photo.model.PhotoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PhotoMapper {
    List<PhotoDto> getPhotoByUserId(PhotoDto photoDto);
    Integer insertPhoto(PhotoDto photoDto);
}
