package com.sut.oep.services;

import com.sut.oep.dao.ClassMapper;
import com.sut.oep.model.Class;
import com.sut.oep.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper classMapper;
    //查询视频列表
    public List<Class> getAllClass(Integer cid){
        return classMapper.selectClassByCid(cid);
    }
    public void delByKey(Integer classid){
        classMapper.deleteByPrimaryKey(classid);
    }
    public void addClass(Class aclass){
        classMapper.insertSelective(aclass);
    }
    public void updateClass(Class aclass){
        classMapper.updateByPrimaryKeySelective(aclass);
    }
    public void delClassByCid(Integer cid){
        classMapper.deleteByPrimaryKey(cid);
    }
    public void delClassByPrimaryKey(Integer classid){
        Class tclass = classMapper.selectByPrimaryKey(classid);
        FileUpload fileUpload = new FileUpload();
        ///courseVedio/2_13.mp4
        fileUpload.delFile("E:/oepfiles/"+tclass.getVedeo());
        classMapper.deleteByPrimaryKey(classid);
    }
   /* public Class updateClassMain(Class uclass){
        Class origin  = classMapper.selectByPrimaryKey(uclass.getClassid());
        FileUpload fileUpload = new FileUpload();
        fileUpload.delFile("E:/oepfiles/"+origin.getVedeo());
        String url = fileUpload.uploadVedio(uclass.getVedeo(), uclass.getClassid(),origin.getCid());
        url = url.replace("E:\\oepfiles", "");
        url = url.replace("\\", "/");
        aClass.setVedeo(url);
        classMapper.updateByPrimaryKeySelective(uclass);
    }*/
    public Class getOneClass(Integer classid){
        return classMapper.selectByPrimaryKey(classid);
    }
}
