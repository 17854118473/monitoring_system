package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.entity.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    List<user> findByPage(int offset, int pageSize);

    int count();

    user selectByUsername(String username);


}