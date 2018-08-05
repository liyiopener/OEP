package com.sut.oep.dao;

import com.sut.oep.model.Kinds;

public interface KindsMapper {
    int deleteByPrimaryKey(Integer kid);

    int insert(Kinds record);

    int insertSelective(Kinds record);

    Kinds selectByPrimaryKey(Integer kid);

    int updateByPrimaryKeySelective(Kinds record);

    int updateByPrimaryKey(Kinds record);
}