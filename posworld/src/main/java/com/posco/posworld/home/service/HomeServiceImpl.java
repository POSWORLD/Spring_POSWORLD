package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;

import com.posco.posworld.home.repository.HomeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class HomeServiceImpl implements HomeService{
    @Autowired
    HomeRepository homeRepository;



    @Override
    public HomeDto getHome(Integer id) {
        return homeRepository.findById(id).get();
    }

    @Override
    public HomeDto insertHome(HomeDto homeDto) {
        return homeRepository.save(homeDto);
    }

    @Override
    public HomeDto updateHome(HomeDto homeDto) {
        HomeDto newHome = getHome(homeDto.getId());
        newHome.setTitle(homeDto.getTitle());
        newHome.setPhoto(homeDto.getPhoto());
        newHome.setContent(homeDto.getContent());
        return homeRepository.save(newHome);
    }

}