package com.posco.posworld.user.service;

import com.posco.posworld.user.model.UserDto;


import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto insertUser(UserDto userDto);
    List<UserDto> findUser();
    UserDto serviceLogin(String userid, String pw);
    UserDto getUserByUserId(String userid);

    UserDto getUserById(Integer id);

    UserDto updateUserById(UserDto userDto);

    Long getUserCount();

//    *List<UserDto> findUser();
//    *UserDto serviceLogin(UserDto userDto);
//    *UserDto getUserByUserId(UserDto userDto);
//    *Integer insertUser(UserDto userDto);
//
//    UserDto getUserById(UserDto userDto);
//
//    Integer updateUserById(UserDto userDto);
//
//    Integer getUserCount();
}
