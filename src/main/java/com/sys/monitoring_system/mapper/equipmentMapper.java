package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.equipment;

import java.util.List;

public interface equipmentMapper {
    int deleteByPrimaryKey(Integer equipmentid);

    int insert(equipment record);

    int insertSelective(equipment record);

    equipment selectByPrimaryKey(Integer equipmentid);

    int updateByPrimaryKeySelective(equipment record);

    int updateByPrimaryKey(equipment record);

    List<equipment> queryEquipment(int userId);


}