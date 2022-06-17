package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;
import com.posco.posworld.home.repository.HomeMapper;
import com.posco.posworld.home.repository.HomeRepository;
import com.posco.posworld.user.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService{
    @Autowired
    HomeRepository homeRepository;

//    @Override
//    public Integer insertHome(HomeDto homeDto) {
//        return homeMapper.insertHome(homeDto);
//    }
//
//    @Override
//    public Integer updateHome(HomeDto homeDto) {
//        return homeMapper.updateHome(homeDto);
//    }

    @Override
    public HomeDto getHome(Integer id) {
        return homeRepository.findById(id).get();
    }

    @Override
    public HomeDto insertHome(HomeDto homeDto) {
        return homeRepository.save(homeDto);
    }

}
