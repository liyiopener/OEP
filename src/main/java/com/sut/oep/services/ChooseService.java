package com.sut.oep.services;

import com.sut.oep.dao.ChooseMapper;
import com.sut.oep.dao.CourseMapper;
import com.sut.oep.model.Choose;
import com.sut.oep.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChooseService {
    @Autowired
    private ChooseMapper chooseMapper;
    @Autowired
    private CourseMapper courseMapper;

    public void addChoose(Choose choose){
        chooseMapper.insertSelective(choose);
    }
    public List<Course> getCourses(Integer uid){
        List<Choose> chooses = chooseMapper.selectByUid(uid);
        List<Course> courses = new ArrayList<Course>();
        for(Choose tmp:chooses){
            courses.add(courseMapper.selectByPrimaryKey(tmp.getCid()));
        }
        return courses;
    }
}
