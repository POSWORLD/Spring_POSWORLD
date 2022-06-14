package com.posco.posworld.board.controller;

import com.posco.posworld.board.model.BoardDto;
import com.posco.posworld.board.service.BoardServiceImpl;
import com.posco.posworld.config.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("board")
public class BoardController {
    @Autowired
    BoardDto boardDto;
    @Autowired
    SecurityService securityService;
    @Autowired
    BoardServiceImpl boardService;
    @GetMapping("/")
    public List<BoardDto> getBoards(){
        boardDto.setHomeId(securityService.getIdAtToken());
        return boardService.getBoards();
    }

    @PostMapping("/")
    public Integer insertBoard(@RequestBody BoardDto boardDto){
       boardDto.setFriendId(securityService.getIdAtToken());
       return boardService.insertBoard(boardDto);

    }


}
