package com.posco.posworld.board.service;


import com.posco.posworld.board.model.BoardDto;
import com.posco.posworld.board.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{
    @Autowired
    BoardMapper boardMapper;
    @Override
    public Integer insertBoard(BoardDto boardDto){
        return boardMapper.insertBoard(boardDto);
    }
    @Override
    public List<BoardDto> getBoardByUser(BoardDto boardDto){
        return boardMapper.getBoardByUser(boardDto);
    }
    @Override
    public List<BoardDto> getBoards(){
        return boardMapper.getBoards();
    }
}
