package com.posco.posworld.pComment.service;

import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.repository.PcommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PcommentServiceImpl implements PcommentService{
    @Autowired
    PcommentMapper pcommentMapper;
    @Override
    public Integer insertPcomment(PcommentDto pcommentDto) {
        return pcommentMapper.insertPComment(pcommentDto);
    }

    @Override
    public List<Map> getCommentbyPhoto(PcommentDto pcommentDto) {
        return pcommentMapper.getCommentbyPhoto(pcommentDto);
    }

    @Override
    public Integer deletePComment(PcommentDto pcommentDto) {
        return pcommentMapper.deletePComment(pcommentDto);
    }


}
