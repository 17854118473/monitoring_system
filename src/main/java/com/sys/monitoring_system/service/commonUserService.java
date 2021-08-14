package com.sys.monitoring_system.service;

import com.sys.monitoring_system.utils.Response;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.RequestParam;

public interface commonUserService {
    public Response queryOldPeopleInfo(int offset, int pageSize, int userId);

    public Response saveOrUpdate(String oldId, String userId, String name, String sex, String height, String weight, String age, String bmi, String tel);

    public Response deleteOldPeopleById(String id);
}
