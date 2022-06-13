package com.posco.posworld.pComment.service;

import com.posco.posworld.pComment.model.PcommentDto;

import java.util.List;

public interface PcommentService {

    Integer insertPcomment(PcommentDto pcommentDto);

    List<PcommentDto> getCommentbyPhoto(PcommentDto pcommentDto);
}
