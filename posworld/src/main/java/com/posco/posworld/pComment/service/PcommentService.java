package com.posco.posworld.pComment.service;

import com.posco.posworld.pComment.model.PcommentDto;

import java.util.List;
import java.util.Optional;

public interface PcommentService {

    PcommentDto insertPcomment(PcommentDto pcommentDto);

    List<PcommentDto> getCommentbyPhoto(PcommentDto pcommentDto);


    Integer deletePComment(PcommentDto pcommentDto);
}
