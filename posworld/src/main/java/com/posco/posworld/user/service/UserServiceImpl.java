package com.posco.posworld.user.service;

import com.posco.posworld.user.model.UserDto;
import com.posco.posworld.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired UserRepository userRepository;
    @Override
    public UserDto insertUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

    @Override
    public List<UserDto> findUser() {
        return userRepository.findAll();
    }

    @Override
    public UserDto serviceLogin(String userid, String pw) {
        return userRepository.findByUseridAndPw(userid,pw);
    }

    @Override
    public UserDto getUserByUserId(String userid) {
        return userRepository.findByUserid(userid);
    }

    @Override
    public UserDto getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserDto updateUserById(UserDto userDto) {
        UserDto newUser = getUserById(userDto.getId());
        newUser.setPw(userDto.getPw());
        newUser.setName(userDto.getName());
        newUser.setProphoto(userDto.getProphoto());
        return userRepository.save(newUser);
    }

    @Override
    public Long getUserCount() {
        return userRepository.count();
    }


//    @Autowired
//    UserMapper userMapper;
//
//    @Override
//    public List<UserDto> findUser() {
//        return userMapper.getUser();
//    }
//
//    @Override
//    public UserDto serviceLogin(UserDto userDto) {
//        return userMapper.getUserByUserIdAndPassword(userDto);
//    }
//
//    @Override
//    public UserDto getUserByUserId(UserDto userDto) {
//        return userMapper.getUserByUserId(userDto);
//    }
//
//    @Override
//    *public Integer insertUser(UserDto userDto) {
//        return userMapper.postUser(userDto);
//    }
//
//    @Override
//    public UserDto getUserById(UserDto userDto) {
//        return userMapper.getUserById(userDto);
//    }
//
//    @Override
//    public Integer updateUserById(UserDto userDto) {
//        return userMapper.updateUserById(userDto);
//    }
//
//    @Override
//    public Integer getUserCount() {
//        return userMapper.getUserCount();
//    }

}


