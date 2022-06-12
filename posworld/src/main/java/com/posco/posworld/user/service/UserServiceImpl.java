package com.posco.posworld.user.service;

import com.posco.posworld.user.model.UserDto;
import com.posco.posworld.user.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> findUser() {
        return userMapper.getUser();
    }
    @Override
    public UserDto findUserById(UserDto userDto) {
        return userMapper.getUserById(userDto);
    }

    @Override
    public Integer insertUser(UserDto userDto) {
        return userMapper.postUser(userDto);
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        return userMapper.getUserByUserIdAndPassword(userDto);
    }
}