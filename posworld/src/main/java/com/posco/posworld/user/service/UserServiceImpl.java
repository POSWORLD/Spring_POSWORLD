package com.posco.posworld.user.service;

import com.posco.posworld.user.model.UserDto;
import com.posco.posworld.user.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public UserDto serviceLogin(UserDto userDto) {
        return userMapper.getUserByUserIdAndPassword(userDto);
    }

    @Override
    public UserDto getUserByUserId(UserDto userDto) {
        return userMapper.getUserByUserId(userDto);
    }

    @Override
    public Integer insertUser(UserDto userDto) {
        return userMapper.postUser(userDto);
    }

    @Override
    public UserDto getUserById(UserDto userDto) {
        return userMapper.getUserById(userDto);
    }

    @Override
    public Integer updateUserById(UserDto userDto) {
        return userMapper.updateUserById(userDto);
    }
}