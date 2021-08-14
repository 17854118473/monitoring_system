package com.sys.monitoring_system.entity;

import java.util.Date;

public class environmental {
    private Integer environmentalid;

    private Integer userid;

    private Float temperature;

    private Float humidity;

    private Float gas;

    private Date time;

    public Integer getEnvironmentalid() {
        return environmentalid;
    }

    public void setEnvironmentalid(Integer environmentalid) {
        this.environmentalid = environmentalid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public void setHumidity(Float humidity) {
        this.humidity = humidity;
    }

    public Float getGas() {
        return gas;
    }

    public void setGas(Float gas) {
        this.gas = gas;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}