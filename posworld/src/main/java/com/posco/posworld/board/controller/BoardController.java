package com.posco.posworld.board.controller;

import com.posco.posworld.board.model.BoardDto;
import com.posco.posworld.board.service.BoardService;
import com.posco.posworld.config.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins="http://localhost:3001")
@RequestMapping("board")
@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    SecurityService securityService;
    @Autowired
    BoardDto boardDto;

    @GetMapping("/{homeid}")
    public List<BoardDto> getBoards(@PathVariable Integer homeid){
        boardDto.setHomeid(Integer.valueOf(homeid))  ;
        return boardService.getBoards(homeid);
    }

    @PostMapping("/")
    public BoardDto insertBoard(@RequestBody BoardDto boardDto){
        try{
            boardDto.setContent(boardDto.getContent());
            boardDto.setFriendid(securityService.getIdAtToken());
            boardDto.setHomeid(boardDto.getHomeid());
        }
        catch (Exception e){
            System.out.println("[ERROR] " + e.getMessage());
        }
        return boardService.insertBoard(boardDto);
    }
//    @PostMapping("/")
//    public BoardDto insertBoard(@RequestBody BoardDto boardDto){
//        try{
//            boardDto.setContent(boardDto.getContent());
//            boardDto.setFriendid(securityService.getIdAtToken());
//            boardDto.setHomeid(boardDto.getHomeid());
//        }
//        catch (Exception e){
//            System.out.println("[ERROR] " + e.getMessage());
//        }
//        return boardService.insertBoard(boardDto);
//    }
//    @PutMapping("/{num}")
////    public Integer updateBoard(@PathVariable Integer num, @RequestBody BoardDto boardDto){
////        BoardDto result;
////        try{
////            boardDto.setFriendid(securityService.getIdAtToken());
////            boardDto.setNum(Integer.valueOf(num));
////            result = boardService.updateBoard(num ,boardDto);
////            return 1 ;
////        }
////        catch (Exception e){
////            return 0;
////        }
       // return boardService.updateBoard(num, boardDto);
  //  }
    @PutMapping("/{num}")
    public Integer updateBoard(@PathVariable Integer num, @RequestBody BoardDto boardDto) {
    try {

        BoardDto newBoard = null;
        newBoard = boardService.updateBoard(num, boardDto);
        return 1;
    }catch (Exception e) {
        return 0;
    }
    }
    @DeleteMapping("/{num}")
    public ResponseEntity<Map<String,Boolean>> deleteBoard(@PathVariable Integer num) {
        return boardService.deleteBoard(num);
    }



}
