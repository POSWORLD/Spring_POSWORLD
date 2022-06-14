package com.posco.posworld.pComment.controller;

import com.posco.posworld.config.SecurityService;
import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.service.PcommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pComment")
public class PcommenController {
    @Autowired
    PcommentDto pcommentDto;

    @Autowired
    SecurityService securityService;

    @Autowired
    PcommentServiceImpl pcommentService;

    @GetMapping("/")
    public Boolean test(){
        return true;
    }
    @GetMapping("/{id}")
    public List<PcommentDto> getPcomment(@PathVariable String id){
        pcommentDto.setPid(Integer.valueOf(id));
        return pcommentService.getCommentbyPhoto(pcommentDto);
    }


    @PostMapping("/")
    public ResponseEntity<?> postPcomment(@RequestBody PcommentDto pcommentDto) {
        HttpStatus httpStatus = pcommentService.insertPcomment(pcommentDto)==1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}")
    public Integer deletePcomment(@PathVariable String id){
        pcommentDto.setId(Integer.valueOf(id));
        pcommentDto.setUserId(securityService.getIdAtToken());
        return pcommentService.deletePComment(pcommentDto);
    }



}
