package com.sut.oep.dao;

import com.sut.oep.model.Choose;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChooseMapper {
    int deleteByPrimaryKey(Integer selectid);

    int insert(Choose record);

    int insertSelective(Choose record);

    Choose selectByPrimaryKey(Integer selectid);

    int updateByPrimaryKeySelective(Choose record);

    int updateByPrimaryKey(Choose record);

    List<Choose> selectByUid(Integer uid);
}