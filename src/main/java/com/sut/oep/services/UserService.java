package com.sut.oep.services;

import com.sut.oep.dao.UserMapper;
import com.sut.oep.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    //判断邮箱是否已注册 存在为true
    public boolean isEmailExist(String email){
        int count = userMapper.selectByEmail(email);
        if(count > 0) return true;
        else return false;
    }
    //判断昵称
    public boolean isNickNameExist(String nickname){
        int count = userMapper.selectByNickName(nickname);
        if(count > 0) return true;
        else return false;
    }

    //用户注册
    public int signUp(User user){
         userMapper.insertSelective(user);
         return user.getUid();
    }

    //用户是否存在
    public User isUserExist(User user){
        return userMapper.loginCheck(user);
    }

    //获取用户信息
    public User getUserInfo(String uids){
        Integer uid = Integer.parseInt(uids);
        return userMapper.selectByPrimaryKey(uid);
    }
    //修改用户信息
    public int updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
