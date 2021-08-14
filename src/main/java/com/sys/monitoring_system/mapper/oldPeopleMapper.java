package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.oldPeople;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface oldPeopleMapper {
    int deleteByPrimaryKey(Integer oldid);

    int insert(oldPeople record);

    int insertSelective(oldPeople record);

    oldPeople selectByPrimaryKey(Integer oldid);

    int updateByPrimaryKeySelective(oldPeople record);

    int updateByPrimaryKey(oldPeople record);

    List<oldPeople> queryByPage(int offset, int pageSize, int userId);

    int count(int userId);
}