package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;
import com.posco.posworld.home.repository.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService{
    @Autowired
    HomeMapper homeMapper;
    @Override
    public Integer InsertPost(HomeDto homeDto) {
        return homeMapper.insertHome(homeDto);
    }
}
