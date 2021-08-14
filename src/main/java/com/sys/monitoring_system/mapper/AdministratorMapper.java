package com.sys.monitoring_system.mapper;

import com.sys.monitoring_system.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.List;

@Mapper
public interface AdministratorMapper {
    List<Administrator> findByPage(int offset, int pageSize);

    int count();

    int deleteByPrimaryKey(Integer id);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer id);

    List<Administrator> findAll();

    Administrator selectByUsername(String username);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectSuperAdminByName(String username);
}