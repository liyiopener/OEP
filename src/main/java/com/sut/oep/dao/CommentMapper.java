package com.sut.oep.dao;

import com.sut.oep.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByClassId(Integer classid);

    List<Comment> selectByUid(Integer uid);
}