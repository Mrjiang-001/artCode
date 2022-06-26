package com.artCode.dao;

import com.artCode.entity.DataCollection;

public interface DataCollectionMapper {
    int deleteByPrimaryKey(String oid);

    int insert(DataCollection record);

    int insertSelective(DataCollection record);

    DataCollection selectByPrimaryKey(String oid);

    int updateByPrimaryKeySelective(DataCollection record);

    int updateByPrimaryKey(DataCollection record);
}