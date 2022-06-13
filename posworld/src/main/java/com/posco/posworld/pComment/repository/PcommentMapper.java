package com.posco.posworld.pComment.repository;

import com.posco.posworld.pComment.model.PcommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PcommentMapper {

    Integer insertPComment(PcommentDto pcommentDto);

    List<PcommentDto> getCommentbyPhoto(PcommentDto pcommentDto);
}
