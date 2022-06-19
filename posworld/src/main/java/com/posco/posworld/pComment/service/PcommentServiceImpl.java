package com.posco.posworld.pComment.service;

import com.posco.posworld.pComment.model.PcommentDto;
import com.posco.posworld.pComment.model.PcommentUserDto;
import com.posco.posworld.pComment.repository.PcommentRepository;
import com.posco.posworld.pComment.repository.PcommentUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PcommentServiceImpl implements PcommentService{
    @Autowired
    PcommentRepository pcommentRepository;

    @Autowired
    PcommentUserRepository pcommentUserRepository;
    @Override
    public PcommentDto insertPcomment(PcommentDto pcommentDto) {
        return pcommentRepository.save(pcommentDto);
    }


    @Override
    public List<PcommentUserDto> getCommentbyPhoto(PcommentDto pcommentDto) {
        return pcommentUserRepository.findByPid(pcommentDto.getPid());
    }

    @Override
    public Integer deletePComment(PcommentDto pcommentDto) {
        return pcommentRepository.deleteByIds(pcommentDto.getId(), pcommentDto.getUserid());
    }


}
