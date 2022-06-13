package com.posco.posworld.pComment.service;

import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.repository.PcommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcommentServiceImpl implements PcommentService{
    @Autowired
    PcommentMapper pcommentMapper;
    @Override
    public Integer insertPcomment(PcommentDto pcommentDto) {
        return pcommentMapper.insertPComment(pcommentDto);
    }

    @Override
    public List<PcommentDto> getCommentbyPhoto(PcommentDto pcommentDto) {
        return pcommentMapper.getCommentbyPhoto(pcommentDto);
    }


}
