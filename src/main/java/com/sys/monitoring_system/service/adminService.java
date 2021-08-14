package com.sys.monitoring_system.service;

import com.sys.monitoring_system.utils.Response;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface adminService {
    public Map<String, Object> findAll();

    // 分页查询
    public Map<String, Object> findByPage(int offset, int pageSize);

    public int deleteById(int id);

    public Response saveOrUpdate(String id, String username, String pwd, String tel);

}
