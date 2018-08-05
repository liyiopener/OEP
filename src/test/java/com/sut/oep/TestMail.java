package com.sut.oep;

import com.sut.oep.model.Course;
import com.sut.oep.services.CourseService;
import com.sut.oep.services.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMail {

    @Qualifier("templateEngine")
    @Autowired
    private SpringTemplateEngine springTemplateEngine;
    @Autowired
    private MailService mailService;
    @Autowired
    private CourseService courseService;
    @Test
    public void testTemp(){
       mailService.activeAcc("5rRJ8l","947795024@qq.com");
    }
    @Test
    public void testDB(){
        for(Course course:courseService.courseListByTea(33))
            System.out.println(course);
    }
}
