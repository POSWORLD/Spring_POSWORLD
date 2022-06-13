package com.posco.posworld.photo.repository;

import com.posco.posworld.photo.model.PhotoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PhotoMapper {
    Integer insertPhoto(PhotoDto photoDto);
    Integer updatePhoto(PhotoDto photoDto);
}
