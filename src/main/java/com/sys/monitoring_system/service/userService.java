package com.sys.monitoring_system.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface userService {
    public Map<String, Object> findAll();

    // 分页查询
    public Map<String, Object> findByPage(int offset, int pageSize);

    public int deleteById(int id);

}
