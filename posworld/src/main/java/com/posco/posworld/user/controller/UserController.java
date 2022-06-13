package com.posco.posworld.user.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.user.model.UserDto;
import com.posco.posworld.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserDto userDto;

    @GetMapping("")
    public List<UserDto> getUser() {return userService.findUser(); }

    @PostMapping("/login")
    @Operation(description = "로그인")
    public Map loginUser(@RequestBody UserDto userDto){
        UserDto loginUser = userService.serviceLogin(userDto);
        String token = securityService.createToken(loginUser.getId().toString());

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("name", loginUser.getName());
        map.put("gender", loginUser.getGender());
        map.put("proPhoto", loginUser.getProPhoto());

        return map;
    }

    @TokenRequired
    @GetMapping("/loginCheck")
    public Boolean loginCheck() {
        return true;
    }

    @PostMapping("/idCheck")
    public Boolean idCheck(@RequestBody UserDto userDto) {
        if(userService.getUserByUserId(userDto) != null){
            return true;
        }
        return false;
    }

    @PostMapping("/join")
    public ResponseEntity<?> postUser(@RequestBody UserDto userDto) {
        HttpStatus httpStatus = userService.insertUser(userDto)==1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }
}
