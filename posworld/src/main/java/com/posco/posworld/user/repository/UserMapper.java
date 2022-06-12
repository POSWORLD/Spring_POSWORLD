package com.posco.posworld.user.repository;

import com.posco.posworld.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> getUser();
    UserDto getUserById(UserDto userDto);
    UserDto getUserByUserIdAndPassword(UserDto userDto);
    Integer postUser(UserDto userDto);
}
