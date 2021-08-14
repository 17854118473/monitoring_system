
package com.sys.monitoring_system.controller;

import com.sys.monitoring_system.config.TokenConfig;
import com.sys.monitoring_system.constarts.Constant;
import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.entity.LoginVo;
import com.sys.monitoring_system.mapper.AdministratorMapper;
import com.sys.monitoring_system.service.RedisService;
import com.sys.monitoring_system.service.loginService;
import com.sys.monitoring_system.utils.JwtTokenUtil;
import com.sys.monitoring_system.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/go")
@CrossOrigin
public class LoginController {
    @Autowired
    private loginService loginService;

    /*
     * 可以用@ReponseBody注入bean的方式
     * 也可以用GetJsonObjectUtils封装的方法，获取出JSON串，再解析出参数。
     * */
    @RequestMapping(value = "login", method = RequestMethod.POST, consumes = "application/json")
    public Response userLogin(@RequestBody LoginVo loginVo){
        String username = loginVo.getUsername();
        String password = loginVo.getPassword();
        String identity = loginVo.getIdentity();
        return loginService.login(username, password, identity);
    }

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public Response info(@RequestParam("token") String token, @RequestParam("id") String id, @RequestParam("identity") String identity){
        return loginService.getInfo(id, identity);
    }

    @ApiOperation(value = "用户登出",notes = "用户登出的接口")
    @GetMapping("/logout")
    public Response<String> logout(HttpServletRequest request){
        return loginService.logout(request);
    }


}
