package com.sut.oep.dao;

import com.sut.oep.model.Class;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {
    int deleteByPrimaryKey(Integer classid);

    int deleteByPrimaryCid(Integer cid);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> selectClassByCid(Integer cid);
}