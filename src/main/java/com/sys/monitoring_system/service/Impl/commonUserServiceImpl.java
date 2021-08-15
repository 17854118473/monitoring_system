package com.sys.monitoring_system.service.Impl;

import com.sys.monitoring_system.entity.environmental;
import com.sys.monitoring_system.entity.equipment;
import com.sys.monitoring_system.entity.oldPeople;
import com.sys.monitoring_system.entity.physiological;
import com.sys.monitoring_system.mapper.enviromentalMapper;
import com.sys.monitoring_system.mapper.equipmentMapper;
import com.sys.monitoring_system.mapper.oldPeopleMapper;
import com.sys.monitoring_system.mapper.physiologicalMapper;
import com.sys.monitoring_system.service.commonUserService;
import com.sys.monitoring_system.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class commonUserServiceImpl implements commonUserService {
    @Autowired
    oldPeopleMapper oldPeopleMapper;

    @Autowired
    enviromentalMapper enviromentalMapper;

    @Autowired
    physiologicalMapper physiologicalMapper;

    @Autowired
    equipmentMapper equipmentMapper;

    @Override
    public Response queryOldPeopleInfo(int offset, int pageSize, int userId){
        List<oldPeople> oldPeoples = oldPeopleMapper.queryByPage(offset,pageSize,userId);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("total", oldPeopleMapper.count(userId));
        map.put("data", oldPeoples);
        return Response.success(map);
    }

    @Override
    public Response queryEnviromentInfo(int userId){
        List<environmental> enviromentals = enviromentalMapper.queryEnviromentInfo(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("data", enviromentals);
        return Response.success(map);
    }

    @Override
    public Response  queryPhysiologyInfo(int userId){
        List<physiological> physiologicals= physiologicalMapper.queryPhysiologyInfo(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("data", physiologicals);
        return Response.success(map);
    }

    @Override
    public Response queryEquipmentInfo(int userId){
        List<equipment> equipment= equipmentMapper.queryEquipment(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("message", "success");
        map.put("data", equipment);
        return Response.success(map);
    }

    @Override
    public Response saveOrUpdate(String oldId, String userId, String name, String sex, String height, String weight, String age, String bmi, String tel){
        if(oldId==null){
            // 插入
            oldPeople oldPeople = new oldPeople();
            oldPeople.setUserid(Integer.parseInt(userId));
            oldPeople.setName(name);
            oldPeople.setAge(Integer.parseInt(age));
            oldPeople.setSex(sex);
            oldPeople.setHeight(Float.parseFloat(height));
            oldPeople.setWeight(Float.parseFloat(weight));
            oldPeople.setBmi(Float.parseFloat(bmi));
            oldPeople.setTel(tel);
            int result = oldPeopleMapper.insert(oldPeople);
            if(result == 1){
                 return Response.success();
            }else{
                return Response.error();
            }
        }else{
            // 更新
            int id = Integer.parseInt(oldId);
            oldPeople oldPeople = oldPeopleMapper.selectByPrimaryKey(id);
            oldPeople.setName(name);
            oldPeople.setAge(Integer.parseInt(age));
            oldPeople.setSex(sex);
            oldPeople.setHeight(Float.parseFloat(height));
            oldPeople.setWeight(Float.parseFloat(weight));
            oldPeople.setBmi(Float.parseFloat(bmi));
            oldPeople.setTel(tel);
            int result = oldPeopleMapper.updateByPrimaryKey(oldPeople);
            if(result == 1){
                return Response.success();
            }else{
                return Response.error();
            }
        }
    }

    @Override
    public Response deleteOldPeopleById(String id){
        int result = oldPeopleMapper.deleteByPrimaryKey(Integer.parseInt(id));
        if(result == 1){
            Map<String, Object> map = new HashMap<>();
            map.put("status", 200);
            map.put("message", "success");
            return Response.success(map);
        }else{
            return Response.error();
        }
    }
}
