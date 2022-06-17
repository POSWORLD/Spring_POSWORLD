package com.posco.posworld.board.service;


import com.posco.posworld.board.model.BoardDto;
import com.posco.posworld.board.repository.BoardMapper;
import io.swagger.models.auth.In;
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
    public List<BoardDto> getBoards(BoardDto boardDto){
        return boardMapper.getBoards(boardDto);
    }

    @Override
    public Integer deleteBoard(BoardDto boardDto){
        return boardMapper.deleteBoard(boardDto);
    }
    @Override
    public Integer updateBoard(BoardDto boardDto){
        return boardMapper.updateBoard(boardDto);
    }

}
