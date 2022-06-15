package com.posco.posworld.user.repository;

import com.posco.posworld.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> getUser();
    UserDto getUserByUserIdAndPassword(UserDto userDto);
    UserDto getUserByUserId(UserDto userDto);
    Integer postUser(UserDto userDto);
    UserDto getUserById(UserDto userDto);
    Integer updateUserById(UserDto userDto);
}
