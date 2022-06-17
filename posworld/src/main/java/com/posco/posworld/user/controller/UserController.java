package com.posco.posworld.user.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;

import com.posco.posworld.user.model.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.posco.posworld.user.service.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {
//    @Autowired
//    UserServiceImpl userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserDto userDto;

    @Autowired
    UserServiceImpl userService;



    @PostMapping("/join")
    public Integer postUser(@RequestBody UserDto userDto) {
        UserDto result = null;
        try{
            userDto.setUserid(userDto.getUserid());
            userDto.setPw(userDto.getPw());
            userDto.setName(userDto.getName());
            userDto.setGender(userDto.getGender());
            userDto.setProphoto("p");
            result = userService.insertUser(userDto);
        }catch (Exception e){

        }
        if(result != null){
            return 1;
        }
        return 0;

    }
    @GetMapping("")
    public List<UserDto> getUser() {return userService.findUser(); }


    @PostMapping("/login")
    @Operation(description = "로그인")
    public Map loginUser(@RequestBody UserDto userDto){
        UserDto loginUser = userService.serviceLogin(userDto.getUserid(), userDto.getPw());
        String token = securityService.createToken(loginUser.getId().toString());

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("name", loginUser.getName());
        map.put("gender", loginUser.getGender());
        map.put("proPhoto", loginUser.getProphoto());
        map.put("id", loginUser.getId());
        return map;
    }
    @TokenRequired
    @GetMapping("/loginCheck")
    public Boolean loginCheck() {
        return true;
    }
    @PostMapping("/idCheck")
    public Boolean idCheck(@RequestBody UserDto userDto) {
        if(userService.getUserByUserId(userDto.getUserid()) != null){
            return true;
        }
        return false;
    }
    @GetMapping("/me")
    @TokenRequired
    public UserDto getUserByMe(){

        userDto.setId(securityService.getIdAtToken());
        return userService.getUserById(userDto.getId());
    }

    @PutMapping("/update")
    @TokenRequired
    public Integer updateUserById(@RequestBody UserDto userDto) {
        userDto.setId(Integer.valueOf(securityService.getIdAtToken()));
        if( userService.updateUserById(userDto)!=null){
            return 1;
        }else{
            return 0;
        }
    }
    @GetMapping("/count")

    public Long getUserCount() {
        return userService.getUserCount();
    }

}
//    @GetMapping("")
//    *public List<UserDto> getUser() {return userService.findUser(); }
//
//    @PostMapping("/login")
//    @Operation(description = "로그인")
//    *public Map loginUser(@RequestBody UserDto userDto){
//        UserDto loginUser = userService.serviceLogin(userDto);
//        String token = securityService.createToken(loginUser.getId().toString());
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("token", token);
//        map.put("name", loginUser.getName());
//        map.put("gender", loginUser.getGender());
//        map.put("proPhoto", loginUser.getProPhoto());
//        map.put("id", loginUser.getId());
//        return map;
//    }
//
//    @TokenRequired
//    @GetMapping("/loginCheck")
//    *public Boolean loginCheck() {
//        return true;
//    }
//
//    @PostMapping("/idCheck")
//    *public Boolean idCheck(@RequestBody UserDto userDto) {
//        if(userService.getUserByUserId(userDto) != null){
//            return true;
//        }
//        return false;
//    }
//
//    @PostMapping("/join")
//    public Integer postUser(@RequestBody UserDto userDto) {
//        Integer result = userService.insertUser(userDto);
//        Integer response = 0;
//        if(result==1){
//            UserDto newUser = userService.getUserByUserId(userDto);
//            homeDto.setUserId(newUser.getId());
//            response = homeService.insertHome(homeDto);
//        }
//        return response;
//    }
//
//    @GetMapping("/me")
//    @TokenRequired
//    *public UserDto getUserByMe(){
//        UserDto userDto = new UserDto();
//        userDto.setId(securityService.getIdAtToken());
//        return userService.getUserById(userDto);
//    }
//
//    @PutMapping("/update")
//    @TokenRequired
//    *public Integer updateUserById(@RequestBody UserDto userDto) {
//        userDto.setId(Integer.valueOf(securityService.getIdAtToken()));
//        return userService.updateUserById(userDto);
//    }
//
//    @GetMapping("/count")
//    @TokenRequired
//    public Integer getUserCount() {
//        return userService.getUserCount();
//    }


