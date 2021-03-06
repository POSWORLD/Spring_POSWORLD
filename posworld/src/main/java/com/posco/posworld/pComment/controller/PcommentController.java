package com.posco.posworld.pComment.controller;

import com.posco.posworld.config.SecurityService;
import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.model.PcommentUserDto;
import com.posco.posworld.pComment.repository.PcommentRepository;
import com.posco.posworld.pComment.service.PcommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pComment")
public class PcommentController {
    @Autowired
    PcommentDto pcommentDto;

    @Autowired
    PcommentRepository pcommentRepository;

    @Autowired
    PcommentServiceImpl pcommentService;

    @GetMapping("/")
    public Boolean test(){
        return true;
    }
    @GetMapping("/{pid}")
    public List<PcommentUserDto> getPcomment(PcommentDto pcommentDto){
        pcommentDto.setPid(pcommentDto.getPid());
        pcommentDto.setUserid(pcommentDto.getUserid());
        return pcommentService.getCommentbyPhoto(pcommentDto);
    }

    @PostMapping("/")
    public ResponseEntity<?> postPcomment(@RequestBody PcommentDto pcommentDto) {
        PcommentDto result = null;
        try{
            pcommentDto.setPid(pcommentDto.getPid());
            pcommentDto.setContent(pcommentDto.getContent());
            pcommentDto.setUserid(pcommentDto.getUserid());

            result = pcommentService.insertPcomment(pcommentDto);
        }catch(Exception e){
            System.out.println("[ERROR] " + e.getMessage());
        }

        HttpStatus httpStatus = (result != null )? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{id}/{userid}")
    public Integer deletePcomment(@PathVariable String id, @PathVariable String userid){
        Integer result = 0;
        pcommentDto.setId(Integer.valueOf(id));
        pcommentDto.setUserid(Integer.valueOf(userid));
        result =  pcommentService.deletePComment(pcommentDto);


        return result;
    }





}
