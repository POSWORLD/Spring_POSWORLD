package com.posco.posworld.home.service;

import com.posco.posworld.home.model.HomeDto;
import com.posco.posworld.user.model.UserDto;


import java.util.List;

public interface HomeService {


    HomeDto getHome(Integer id);
    HomeDto insertHome(HomeDto homeDto);
    HomeDto updateHome(HomeDto homeDto);



}