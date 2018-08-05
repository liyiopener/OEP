package com.sut.oep.dao;

import com.sut.oep.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectCoursesByTeacher(Integer tid);

    List<Course> selectCourseBykid(Integer kid);

    Course selectByCname(String cname);
}