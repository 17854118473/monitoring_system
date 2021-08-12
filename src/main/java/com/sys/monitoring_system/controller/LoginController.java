
package com.sys.monitoring_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.sys.monitoring_system.config.TokenConfig;
import com.sys.monitoring_system.constarts.Constant;
import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.entity.loginVo;
import com.sys.monitoring_system.mapper.AdministratorMapper;
import com.sys.monitoring_system.service.RedisService;
import com.sys.monitoring_system.utils.GetJsonObjectUtils;
import com.sys.monitoring_system.utils.JwtTokenUtil;
import com.sys.monitoring_system.utils.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
@CrossOrigin
public class LoginController {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Autowired
    private TokenConfig tokenConfig;

    @Autowired
    private RedisService redisService;

    /*
     * 可以用@ReponseBody注入bean的方式
     * 也可以用GetJsonObjectUtils封装的方法，获取出JSON串，再解析出参数。
     * */
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = "application/json")
    public Response userLogin(@RequestBody loginVo a){
//        JSONObject jsonObject = GetJsonObjectUtils.getParam(request);
//        String username = jsonObject.get("username").toString();
//        String password = jsonObject.get("password").toString();
        String username = a.getUsername();
        String password = a.getPassword();
        Administrator administrator = administratorMapper.selectByUsername(username);
        if(password.equals(administrator.getPwd())){
            String accessToken = JwtTokenUtil.getInstance()
                    .setIssuer(tokenConfig.getIssuer())
                    .setSecret("223355a")
                    .setSubObject(username)
                    .generateToken();
            // 每次登录的时候吧token放到 redis，用于只能一个账号同时在线
            System.out.println(accessToken);
            redisService.set(Constant.JWT_USER_NAME+username,accessToken);
            // 每次登录先删除需要重新登录的标记
            redisService.delete(Constant.JWT_USER_LOGIN_BLACKLIST+username);
            Map<String, Object> map = new HashMap<>(2);
            map.put("token", accessToken);
            return Response.success("正确", map);
        }else{
            return Response.error("密码错误");
        }
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public Response info(){
        // System.out.println(accessToken);
        Map<String,Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "小周");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        String[] a = {"admin"};
        map.put("roles", a);
        return Response.success(map);
    }

    @ApiOperation(value = "用户登出",notes = "用户登出的接口")
    @GetMapping("/logout")
    public Response<String> logout(HttpServletRequest request){
        String accessToken = null;
        //String refreshToken = null;
        // 退出时，不管成功还是失败都要退出
        try {
            accessToken = request.getHeader(Constant.ACCESS_TOKEN);
            //refreshToken = request.getHeader(Constant.REFRESH_TOKEN);
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
