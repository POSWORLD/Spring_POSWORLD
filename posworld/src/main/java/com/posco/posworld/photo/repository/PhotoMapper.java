package com.posco.posworld.photo.repository;

import com.posco.posworld.photo.model.PhotoDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PhotoMapper {
    Integer insertPhoto(PhotoDto photoDto);
    Integer updatePhoto(PhotoDto photoDto);
    Integer deletePhoto(PhotoDto photoDto);

    List<PhotoDto> selectPhoto(PhotoDto photoDto);

    PhotoDto selectPhotoById(PhotoDto photoDto);
}
