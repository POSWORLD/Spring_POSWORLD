package com.posco.posworld.home.repository;

import com.posco.posworld.home.model.HomeDto;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    HomeDto getHome(HomeDto homeDto);

    Integer insertHome(HomeDto homeDto);
    Integer updateHome(HomeDto homeDto);
    HomeDto getHome(HomeDto homeDto);

}
