package com.posco.posworld.user.controller;

import com.posco.posworld.aspect.TokenRequired;
import com.posco.posworld.config.SecurityService;
import com.posco.posworld.user.model.UserDto;
import com.posco.posworld.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/")
    @TokenRequired
    public List<UserDto> getUser()
    {
        return userService.findUser();
    }

    @GetMapping("/{id}")
    @TokenRequired
    public UserDto getUserById(@PathVariable String id){
        UserDto userDto = new UserDto();
        userDto.setId(Integer.valueOf(id));
        return userService.findUserById(userDto);
    }

    @PostMapping("/join")
    public ResponseEntity<?> postUser(@RequestBody UserDto userDto){
        HttpStatus httpStatus = userService.insertUser(userDto)==1
                ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }

    @GetMapping("/token")
    @TokenRequired
    public  String getToken(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String tokenBearer = request.getHeader("Authorization"); //header에서 얻어오기
        String subject = securityService.getSubject(tokenBearer);
        return subject;
    }

    @PostMapping("/login")
    @Operation(description = "로그인")
    public Map getUserByUserIdAndPassword(@RequestBody UserDto userDto){
        UserDto loginUser = userService.loginUser(userDto);
        String token = securityService.createToken(loginUser.getId().toString());
        Map<String ,Object> map = new HashMap<>();
        map.put("token", token);
        map.put("name", loginUser.getName());
        map.put("gender",loginUser.getGender());

        return map;
    }

    @TokenRequired
    @GetMapping("/check")
    public Boolean check() {
        return true;
    }
}
