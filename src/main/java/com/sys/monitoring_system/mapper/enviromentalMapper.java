package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.environmental;
import com.sys.monitoring_system.entity.oldPeople;

import java.util.List;

public interface enviromentalMapper {
    int deleteByPrimaryKey(Integer environmentalid);

    int insert(environmental record);

    int insertSelective(environmental record);

    environmental selectByPrimaryKey(Integer environmentalid);

    int updateByPrimaryKeySelective(environmental record);

    int updateByPrimaryKey(environmental record);

    List<environmental> queryEnviromentInfo(int userId);
}