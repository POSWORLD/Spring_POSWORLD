package com.posco.posworld.pComment.controller;

import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.service.PcommentServiceImpl;
import com.posco.posworld.user.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pComment")
public class PcommenController {
    @Autowired
    PcommentDto pcommentDto;
    @Autowired
    PcommentServiceImpl pcommentService;

    @GetMapping("/")
    public Boolean test(){
        return true;
    }


    @PostMapping("/")
    public ResponseEntity<?> postUser(@RequestBody PcommentDto pcommentDto) {
        HttpStatus httpStatus = pcommentService.insertPcomment(pcommentDto)==1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }

}
