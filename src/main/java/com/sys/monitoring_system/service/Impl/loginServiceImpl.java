package com.sys.monitoring_system.service.Impl;

import com.sys.monitoring_system.config.TokenConfig;
import com.sys.monitoring_system.constarts.Constant;
import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.mapper.AdministratorMapper;
import com.sys.monitoring_system.service.RedisService;
import com.sys.monitoring_system.service.loginService;
import com.sys.monitoring_system.utils.JwtTokenUtil;
import com.sys.monitoring_system.utils.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private AdministratorMapper administratorMapper;

    @Autowired
    private TokenConfig tokenConfig;

    @Autowired
    private RedisService redisService;

    @Override
    public Response login(String username, String password, String identity){
        String realPassword;
        int id;
        if(identity.equals("superAdmin")){
            Administrator administrator = administratorMapper.selectSuperAdminByName(username);
            realPassword = administrator.getPwd();
            id = administrator.getId();
        }else if(identity.equals("admin")){
            Administrator administrator = administratorMapper.selectByUsername(username);
            realPassword = administrator.getPwd();
            id = administrator.getId();
        }else{
            realPassword = "搜索到普通用户的密码";
            id = 0;
        }
        if(password.equals(realPassword)){
            String accessToken = JwtTokenUtil.getInstance()
                    .setIssuer(tokenConfig.getIssuer())
                    .setSecret("223355a")
                    .setSubObject(username)
                    .generateToken();
            // 每次登录的时候吧token放到 redis，用于只能一个账号同时在线
            redisService.set(Constant.JWT_USER_NAME+username,accessToken);
            // 每次登录先删除需要重新登录的标记
            redisService.delete(Constant.JWT_USER_LOGIN_BLACKLIST+username);
            Map<String, Object> map = new HashMap<>(2);
            map.put("accessToken", accessToken);
            map.put("id", id);
            map.put("identity", "admin");
            return Response.success(map);
        }else{
            return Response.error("密码错误");
        }
    }

    @Override
    public Response getInfo(String id, String identity){
        int Id = Integer.parseInt(id);
        if(identity.equals("user")){
            return Response.success();
        }else{
            Administrator administrator = administratorMapper.selectByPrimaryKey(Id);
            Map<String,Object> map = new HashMap<>();
            map.put("id", administrator.getId());
            map.put("name", administrator.getUsername());
            map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            String[] a = {identity};
            map.put("roles", a);
            return Response.success(map);
        }
    }

    @Override
    public Response logout(HttpServletRequest request){
        String accessToken = null;
        //String refreshToken = null;
        // 退出时，不管成功还是失败都要退出
        try {
            accessToken = request.getHeader("X-Token");
            if (StringUtils.isBlank(accessToken)){
                System.out.println("token为空");
            }
            return Response.success();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Response.success();
    }

}
