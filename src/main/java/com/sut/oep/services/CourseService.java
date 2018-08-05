package com.sut.oep.services;

import com.github.pagehelper.PageHelper;
import com.sut.oep.dao.CourseMapper;
import com.sut.oep.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    //创建课程
    public int createCourse(Course course){
        courseMapper.insertSelective(course);
        return course.getCid();
    }
    //修改课程信息
    public int updateCourse(Course course){
        return courseMapper.updateByPrimaryKeySelective(course);
    }
    //老师自己的课程
    public List<Course> courseListByTea(Integer tid){
        return courseMapper.selectCoursesByTeacher(tid);
    }
    public Course selectCourseByKey(Integer cid){
        return courseMapper.selectByPrimaryKey(cid);
    }
    public void delCourse(Integer cid){
        courseMapper.deleteByPrimaryKey(cid);
    }
    public List<Course> getListBykId(Integer kid){
        System.out.println(courseMapper.selectCourseBykid(kid));
        return courseMapper.selectCourseBykid(kid);

    }
    public Course findCourse(String cname){
        return courseMapper.selectByCname(cname);
    }
}
