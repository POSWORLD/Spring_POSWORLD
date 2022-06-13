package com.posco.posworld.pComment.repository;

import com.posco.posworld.pComment.model.PcommentDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PcommentMapper {

    Integer insertPComment(PcommentDto pcommentDto);
}
