package com.sut.oep.services;

import com.sut.oep.dao.ClassMapper;
import com.sut.oep.dao.CommentMapper;
import com.sut.oep.dao.CourseMapper;
import com.sut.oep.dao.UserMapper;
import com.sut.oep.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ClassMapper classMapper;
    public void addComment(Comment comment){
        commentMapper.insertSelective(comment);
    }
    public List<Comment> getAllCommentByClassId(Integer classid){
         List<Comment> comments = commentMapper.selectByClassId(classid);
         for(Comment comment:comments){
             Integer uid = comment.getUid();
             comment.setUser(userMapper.selectByPrimaryKey(uid));
         }
         return comments;
    }
    public List<Comment> getAllCommentByUid(Integer uid){
        List<Comment> comments = commentMapper.selectByUid(uid);
        for(Comment comment:comments){
            comment.setCourse(courseMapper.selectByPrimaryKey(comment.getCid()));
            comment.setaClass(classMapper.selectByPrimaryKey(comment.getClassid()));
        }
        return comments;
    }
    public void delCommentByKey(Integer commentid){
        commentMapper.deleteByPrimaryKey(commentid);
    }
}
