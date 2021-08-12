package com.sys.monitoring_system.controller;

import com.sys.monitoring_system.service.userService;
import com.sys.monitoring_system.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/user")
@CrossOrigin
public class userController {
    @Autowired
    userService userService;

    /*分页查询普通管理员的信息*/
    @PostMapping("/query")
    public Response query(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return Response.success(userService.findByPage(page*pageSize, pageSize));
    }

    @PostMapping("/Update")
    public Response Update(@RequestParam("userid") String id,@RequestParam("username") String username,@RequestParam("pwd") String pwd,@RequestParam("tel") String tel,@RequestParam("email") String email,@RequestParam("wechat") String wechat){
        return userService.update(id, username, pwd, tel, email, wechat);
    }

    @GetMapping("/deleteById")
    public Response deleteById(@RequestParam("id") String id){
        System.out.println("执行");
        return userService.delete(id);
    }

    @PostMapping("/selectByUsername")
    public Response selectByUsername(@RequestParam("username") String username){
        return userService.selectByUsername(username);
    }

}
