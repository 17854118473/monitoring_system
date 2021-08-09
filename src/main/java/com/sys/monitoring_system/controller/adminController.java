package com.sys.monitoring_system.controller;

import com.sys.monitoring_system.entity.Administrator;
import com.sys.monitoring_system.mapper.AdministratorMapper;
import com.sys.monitoring_system.service.userService;
import com.sys.monitoring_system.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/admin")
@CrossOrigin
public class adminController {
    @Autowired
    private userService userService;

    @Autowired
    private AdministratorMapper administratorMapper;

    /*
     * 查询所有普通管理员的信息，没有用到
     * */
    @GetMapping("/findAll")
    public Response findAll(){
        return Response.success(userService.findAll());
    }

    /*分页查询普通管理员的信息*/
    @PostMapping("/query")
    public Response query(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){
        return Response.success(userService.findByPage(page*pageSize, pageSize));
    }

    @GetMapping("deleteById")
    public Response deleteById(@RequestParam("id") String id){
        int result = userService.deleteById(Integer.parseInt(id));
        if(result == 1){
            Map<String, Object> map = new HashMap<>();
            map.put("status", 200);
            map.put("message", "success");
            return Response.success(map);
        }else{
            return Response.error();
        }
    }

    @PostMapping("saveOrUpdate")
    public Response saveOrUpdate(@RequestParam("id") String id, @RequestParam("username") String username, @RequestParam("pwd") String pwd, @RequestParam("tel") String tel){
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

    @PostMapping(value = "selectByUsername")
    public Response selectByUsername(@RequestParam("username") String searchName){
        Administrator administrator = administratorMapper.selectByUsername(searchName);
        List<Administrator> administrators = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        if(administrator!=null){
            administrators.add(administrator);
        }
        map.put("data", administrators);
        return Response.success(map);

    }


}
