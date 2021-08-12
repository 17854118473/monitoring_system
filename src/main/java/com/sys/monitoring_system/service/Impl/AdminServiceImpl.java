package com.sys.monitoring_system.service.Impl;

import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.mapper.AdministratorMapper;
import com.sys.monitoring_system.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements adminService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Map<String, Object> findAll(){
        List<Administrator> administrators = administratorMapper.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("data", administrators);
        return map;
    }

    @Override
    public Map<String, Object> findByPage(int offset, int pageSize){
        List<Administrator> administrators = administratorMapper.findByPage(offset, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("total", administratorMapper.count());
        map.put("data", administrators);
        return map;
    }

    @Override
    public int deleteById(int id){
        return administratorMapper.deleteByPrimaryKey(id);
    }
}
