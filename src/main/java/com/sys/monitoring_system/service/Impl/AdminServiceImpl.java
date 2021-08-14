package com.sys.monitoring_system.service.Impl;

import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.mapper.AdministratorMapper;
import com.sys.monitoring_system.service.adminService;
import com.sys.monitoring_system.utils.Response;
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

    @Override
    public Response saveOrUpdate(String id, String username, String pwd, String tel){
        if(id != ""){
            // 说明已经有该管理员，之后执行更新操作
            Administrator administrator = administratorMapper.selectByPrimaryKey(Integer.parseInt(id));
            administrator.setUsername(username);
            administrator.setTel(tel);
            administrator.setPwd(pwd);
            if(administratorMapper.updateByPrimaryKey(administrator) == 1){
                Map<String, Object> map = new HashMap<>();
                map.put("status", 200);
                map.put("message", "success");
                return Response.success(map);
            }else{
                return Response.error();
            }
        }else{
            // 说明前台正在执行插入操作
            Administrator administrator = new Administrator();
            administrator.setUsername(username);
            administrator.setPwd(pwd);
            administrator.setCategory(0);
            administrator.setTel(tel);
            administrator.setEmail("5151");
            if(administratorMapper.insert(administrator) == 1){
                Map<String, Object> map = new HashMap<>();
                map.put("status", 200);
                map.put("message", "success");
                return Response.success(map);
            }else{
                return Response.error();
            }
        }
    }
}
