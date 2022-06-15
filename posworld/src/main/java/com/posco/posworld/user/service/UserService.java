package com.posco.posworld.user.service;

import com.posco.posworld.user.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findUser();
    UserDto serviceLogin(UserDto userDto);
    UserDto getUserByUserId(UserDto userDto);
    Integer insertUser(UserDto userDto);

    UserDto getUserById(UserDto userDto);

    Integer updateUserById(UserDto userDto);
   
}
