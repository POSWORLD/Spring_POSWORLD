package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;

public interface HomeService {
    Integer InsertHome(HomeDto homeDto);
    Integer UpdateHome(HomeDto homeDto);
}
