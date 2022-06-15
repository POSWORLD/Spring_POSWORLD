package com.posco.posworld.pComment.service;

import com.posco.posworld.pComment.model.PcommentDto;

import java.util.List;
import java.util.Map;

public interface PcommentService {

    Integer insertPcomment(PcommentDto pcommentDto);

    List<Map> getCommentbyPhoto(PcommentDto pcommentDto);

    Integer deletePComment(PcommentDto pcommentDto);
}
