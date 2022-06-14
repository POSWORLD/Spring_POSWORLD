package com.posco.posworld.home.repository;

import com.posco.posworld.home.model.HomeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {
    Integer insertHome(HomeDto homeDto);
    Integer updateHome(HomeDto homeDto);

}
