package com.posco.posworld.pComment.repository;

import com.posco.posworld.pComment.model.PcommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PcommentMapper {

    Integer insertPComment(PcommentDto pcommentDto);

    List<Map> getCommentbyPhoto(PcommentDto pcommentDto);

    Integer deletePComment(PcommentDto pcommentDto);
}
