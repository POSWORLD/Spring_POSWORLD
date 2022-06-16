package com.posco.posworld.home.repository;

import com.posco.posworld.home.model.HomeDto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMapper extends JpaRepository<HomeDto, Integer> {
    HomeDto getHome(HomeDto homeDto);

    Integer insertHome(HomeDto homeDto);
    Integer updateHome(HomeDto homeDto);

}
