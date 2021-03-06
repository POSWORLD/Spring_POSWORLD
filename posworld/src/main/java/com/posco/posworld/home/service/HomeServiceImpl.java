package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;

import com.posco.posworld.home.repository.HomeRepository;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    public HomeDto updateHomeContent(HomeDto homeDto) {
        HomeDto newHome = getHome(homeDto.getId());

        newHome.setContent(homeDto.getContent());
        return homeRepository.save(newHome);
    }

    @Override
    public HomeDto updateHomePhoto(HomeDto homeDto) {
        HomeDto newHome = getHome(homeDto.getId());

        newHome.setPhoto(homeDto.getPhoto());
        return homeRepository.save(newHome);
    }

    @Transactional
    public void deleteHome(Integer id) {
        homeRepository.deleteById(id);
    }

}