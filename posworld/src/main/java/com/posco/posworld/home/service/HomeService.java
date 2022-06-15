package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;

public interface HomeService {
    Integer insertHome(HomeDto homeDto);
    Integer updateHome(HomeDto homeDto);
    HomeDto getHome(HomeDto homeDto);
}
