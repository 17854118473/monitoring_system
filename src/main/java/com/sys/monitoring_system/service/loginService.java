package com.sys.monitoring_system.service;

import com.sys.monitoring_system.utils.Response;

import javax.servlet.http.HttpServletRequest;

public interface loginService {
    public Response login(String username, String password, String identity);

    public Response getInfo(String id, String identity);

    public Response logout(HttpServletRequest request);
}
