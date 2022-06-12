package com.posco.posworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("/")
    public List<String> Hello(){
        return Arrays.asList("서버 포트는 8001", "리액트 포트는 3001");
    }
}
