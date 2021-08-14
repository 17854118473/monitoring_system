package com.sys.monitoring_system.controller;


import com.sys.monitoring_system.service.commonUserService;
import com.sys.monitoring_system.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/commonUser")
@CrossOrigin
public class commonUserController {
    @Autowired
    private commonUserService commonUserService;

    @RequestMapping("queryOldPeopleInfo")
    public Response queryOldPeopleInfo(@RequestParam("page") String page, @RequestParam("pageSize") String pageSize, @RequestParam("userId") String userId){
        return commonUserService.queryOldPeopleInfo(Integer.parseInt(page), Integer.parseInt(pageSize), Integer.parseInt(userId));
    }

    @RequestMapping("queryEnviromentInfo")
    public Response queryEnviromentInfo( @RequestParam("userId") String userId){
        System.out.println("获取环境信息");
        return commonUserService.queryEnviromentInfo(Integer.parseInt(userId));
    }

    @RequestMapping("saveOrUpdate")
    public Response saveOrUpdate(@RequestParam("oldid") String oldId, @RequestParam("userid") String userId,@RequestParam("name") String name,@RequestParam("sex") String sex,@RequestParam("height") String height,@RequestParam("weight") String weight,@RequestParam("age") String age,@RequestParam("bmi") String bmi,@RequestParam("tel") String tel){
        return commonUserService.saveOrUpdate(oldId, userId, name, sex, height, weight, age, bmi, tel);
    }

    @GetMapping("deleteOldPeopleById")
    public Response deleteById(@RequestParam("id") String id){
        return commonUserService.deleteOldPeopleById(id);
    }

}
