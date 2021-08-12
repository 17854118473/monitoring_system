package com.sys.monitoring_system.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.sys.monitoring_system.entity.user;
import com.sys.monitoring_system.utils.Response;

import java.util.List;
import java.util.Map;

public interface userService {
    Map<String, Object> findByPage(int offset, int pageSize);

    public Response update(String id,String username,String pwd,String tel,String email,String wechat);

    public Response delete(String id);

    public Response selectByUsername(String username);

}
