package com.sut.oep.controller;

import com.github.pagehelper.PageHelper;
import com.sut.oep.dao.ChooseMapper;
import com.sut.oep.model.Choose;
import com.sut.oep.model.Class;
import com.sut.oep.model.Comment;
import com.sut.oep.model.Course;
import com.sut.oep.services.ChooseService;
import com.sut.oep.services.ClassService;
import com.sut.oep.services.CommentService;
import com.sut.oep.services.CourseService;
import com.sut.oep.util.FileUpload;
import com.sut.oep.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/Course")
@Controller
public class CourseContro {
    @Autowired
    private ClassService classService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ChooseService chooseService;

    //发布课程
    @PostMapping("/addCourse")
    public String add_course(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uid = session.getAttribute("uid").toString();
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile image = ((MultipartHttpServletRequest) request)
                .getFile("cimage");
        Course course = new Course();
        course.setKid(Integer.parseInt(params.getParameter("kid")));
        course.setCname(params.getParameter("cname"));
        course.setTid(Integer.parseInt(uid));
        course.setCid(courseService.createCourse(course));
        FileUpload fileUpload = new FileUpload();
        String url = fileUpload.uploadCimage(image, course.getCid());
        url = url.replace("E:\\oepfiles", "");
        url = url.replace("\\", "/");
        course.setImage(url);
        //course.setImage(fileUpload.uploadCimage(image,course.getCid()));
        course.setCreateTime(TimeFormat.getTime());
        courseService.updateCourse(course);
        return "user/tuCourse";
    }

    @ResponseBody
    @GetMapping("/t_courseList")
    public List<Course> t_courseList(Integer pageNum, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Integer tid = Integer.parseInt(session.getAttribute("uid").toString());
        return courseService.courseListByTea(tid);
    }

    @RequestMapping("/t_Edit")
    public ModelAndView to_course_edit(@RequestParam("cid") Integer cid) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/tuCEdit");
        Course course = courseService.selectCourseByKey(cid);
        mv.addObject("course", course);
        List<Class> classList = classService.getAllClass(cid);
        mv.addObject("classlist", classList);
        mv.addObject("cid", cid);
        return mv;
    }
    @GetMapping("/del")
    public void delCourse(@RequestParam("cid")Integer cid){
        courseService.delCourse(cid);
        classService.delClassByCid(cid);
    }
    @ResponseBody
    @GetMapping("/getCourseListByKinds")
    public List<Course> getCourseListByKinds(@RequestParam("kid")Integer kid){
        return courseService.getListBykId(kid);
    }
    @GetMapping("/toCourseInfo")
    public ModelAndView toCourseInfo(@RequestParam("cid") Integer cid) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/user/courseInfo");
        Course course = courseService.selectCourseByKey(cid);
        mv.addObject("course", course);
        List<Class> classList = classService.getAllClass(cid);
        mv.addObject("classlist", classList);
        mv.addObject("cid", cid);
        return mv;
    }
    @GetMapping("/toVideo")
    public ModelAndView toVideo(HttpServletRequest request,@RequestParam("classid")Integer classid){
        Class sclass = classService.getOneClass(classid);
        List<Class> clist = classService.getAllClass(sclass.getCid());
        List<Comment> comments = commentService.getAllCommentByClassId(classid);
        for(Comment tmo:comments)
            System.out.println(tmo);
        Choose choose = new Choose();
        choose.setCid(sclass.getCid());
        choose.setSid(Integer.parseInt(request.getSession().getAttribute("uid").toString()));
        choose.setClassid(classid);
        chooseService.addChoose(choose);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user/videoPlay");
        mv.addObject("class",sclass);
        mv.addObject("classlist",clist);
        mv.addObject("comments",comments);
        return mv;
    }
    @PostMapping("/findCourse")
    public String findCourse(@RequestParam("fcname") String cname){
        Course course = courseService.findCourse(cname);
        return "redirect:/Course/toCourseInfo?cid="+course.getCid();
    }
}
