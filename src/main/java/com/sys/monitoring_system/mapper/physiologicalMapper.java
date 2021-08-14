package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.physiological;

import java.util.List;

public interface physiologicalMapper {
    int deleteByPrimaryKey(Integer physiologicalid);

    int insert(physiological record);

    int insertSelective(physiological record);

    physiological selectByPrimaryKey(Integer physiologicalid);

    int updateByPrimaryKeySelective(physiological record);

    int updateByPrimaryKey(physiological record);

    List<physiological> queryPhysiologyInfo(int userId);
}