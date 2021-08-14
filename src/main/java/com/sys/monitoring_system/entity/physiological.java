package com.sys.monitoring_system.entity;

import java.util.Date;

public class physiological {
    private Integer physiologicalid;

    private Integer userid;

    private Integer oldid;

    private Float bloodPressure;

    private Float bloodSugar;

    private Float gas;

    private Date time;

    public Integer getPhysiologicalid() {
        return physiologicalid;
    }

    public void setPhysiologicalid(Integer physiologicalid) {
        this.physiologicalid = physiologicalid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    public Float getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Float bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public Float getBloodSugar() {
        return bloodSugar;
    }

    public void setBloodSugar(Float bloodSugar) {
        this.bloodSugar = bloodSugar;
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