package com.sut.oep.controller;

import com.sut.oep.model.Class;
import com.sut.oep.model.Course;
import com.sut.oep.services.ClassService;
import com.sut.oep.util.FileUpload;
import com.sut.oep.util.TimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/Class")
public class ClassContro {
    @Autowired
    private ClassService classService;

    @RequestMapping("/addClass")
    public String add_course(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uid = session.getAttribute("uid").toString();
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile vedio = ((MultipartHttpServletRequest) request)
                .getFile("vedio");
        Class aClass = new Class();
        String cid = params.getParameter("cid");
        aClass.setCid(Integer.parseInt(cid));
        aClass.setTitle(params.getParameter("title"));
        aClass.setRefreshTime(TimeFormat.getTime());
        classService.addClass(aClass);
        FileUpload fileUpload = new FileUpload();
        String url = fileUpload.uploadVedio(vedio, aClass.getClassid(),aClass.getCid());
        url = url.replace("E:\\oepfiles", "");
        url = url.replace("\\", "/");
        aClass.setVedeo(url);
        classService.updateClass(aClass);
        return "redirect:/Course/t_Edit?cid="+cid;
    }
    @GetMapping("del")
    public void delClass(@RequestParam("classid")Integer classid){
        classService.delClassByPrimaryKey(classid);
    }
    @RequestMapping("update")
    public String updateClass(HttpServletRequest request){
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile vedio = ((MultipartHttpServletRequest) request)
                .getFile("u_vedio");
        Class uclass = new Class();
        String classid = params.getParameter("u_classid");
        uclass.setClassid(Integer.parseInt(classid));
        uclass.setTitle(params.getParameter("u_title"));
        Class origin  = classService.getOneClass(uclass.getClassid());
        FileUpload fileUpload = new FileUpload();
        fileUpload.delFile("E:/oepfiles/"+origin.getVedeo());
        String url = fileUpload.uploadVedio(vedio, uclass.getClassid(),origin.getCid());
        url = url.replace("E:\\oepfiles", "");
        url = url.replace("\\", "/");
        uclass.setVedeo(url);
        classService.updateClass(uclass);
        return "redirect:/Course/t_Edit?cid="+origin.getCid();
    }
}
