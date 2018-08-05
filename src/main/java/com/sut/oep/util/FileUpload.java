package com.sut.oep.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUpload {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    //单文件上传
    public String  UploadOne(MultipartFile file){
        if (file.isEmpty()) {
            return "文件为空";
        }
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        String filePath = "E:\\oepfiles\\headimg\\";
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            File newFile = new File(filePath + "243242"+suffixName);
            System.out.println(newFile.getPath());;
            dest.renameTo(newFile);
            return "上传成功";
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }


    public String  uploadCimage(MultipartFile file,Integer cid){
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        //String filePath = "E:\\oepfiles\\courseimg\\";
        String filePath = "E:\\oepfiles\\courseImg\\";
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            File newFile = new File(filePath +cid+suffixName);
            dest.renameTo(newFile);
            return newFile.getPath();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
    public String  uploadVedio(MultipartFile file,Integer classid,Integer cid){
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径
        //String filePath = "E:\\oepfiles\\courseimg\\";
        String filePath = "E:\\oepfiles\\courseVedio\\";
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            File newFile = new File(filePath +cid+"_"+classid+suffixName);
            dest.renameTo(newFile);
            return newFile.getPath();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
    //删除文件
    public void delFile(String name){
        File file  = new File(name);
        file.delete();
    }

}
