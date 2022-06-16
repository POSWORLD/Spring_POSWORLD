package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;


import java.util.List;

public interface HomeService {
    HomeDto getHome(HomeDto homeDto);

    Integer InsertHome(HomeDto homeDto);
    Integer UpdateHome(HomeDto homeDto);
}
