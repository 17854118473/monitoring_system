package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.old_data;

public interface old_dataMapper {
    int deleteByPrimaryKey(Integer oldid);

    int insert(old_data record);

    int insertSelective(old_data record);

    old_data selectByPrimaryKey(Integer oldid);

    int updateByPrimaryKeySelective(old_data record);

    int updateByPrimaryKey(old_data record);
}