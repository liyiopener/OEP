package com.sut.oep.dao;

import com.sut.oep.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectByEmail(String email);

    int selectByNickName(String nickname);

    User loginCheck(User user);
}