package com.posco.posworld.user.service;

import com.posco.posworld.user.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findUser();
    UserDto findUserById(UserDto userDto);
    Integer insertUser(UserDto userDto);
    UserDto loginUser(UserDto userDto);
}