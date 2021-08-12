package com.sys.monitoring_system.service.Impl;

import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.entity.user;
import com.sys.monitoring_system.mapper.userMapper;
import com.sys.monitoring_system.service.userService;
import com.sys.monitoring_system.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class userServiceImpl implements userService {

    @Autowired
    userMapper userMapper;

    @Override
    public Map<String, Object> findByPage(int offset, int pageSize) {
        List<user> byPage = userMapper.findByPage(offset, pageSize);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("total", userMapper.count());
        map.put("data", byPage);
        return map;

    }

    @Override
    public Response update(String id,String username,String pwd,String tel,String email,String wechat){
    user user =userMapper.selectByPrimaryKey(Integer.parseInt(id));
    user.setUsername(username);
    user.setPwd(pwd);
    user.setTel(tel);
    user.setEmail(email);
    user.setWechat(wechat);
    if(userMapper.updateByPrimaryKey(user)==1){
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","success");
        return  Response.success(map);
    }else{
        return  Response.error();
    }

    }

    @Override
    public Response delete(String id){
        int result=userMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if (result==1){
            Map<String,Object> map=new HashMap<>();
            map.put("status",200);
            map.put("message","success");
            return  Response.success(map);
        }else{
            return  Response.error();
        }
    }

    public Response selectByUsername(String username){
        user user= userMapper.selectByUsername(username);
        Map<String,Object> map=new HashMap<>();
        map.put("status",200);
        map.put("message","success");
        List<user> users = new ArrayList<>();
        if (user!=null){
            users.add(user);
        }
        map.put("data", users);
        return  Response.success(map);
    }

}
