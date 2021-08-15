package com.sys.monitoring_system.entity;

import java.util.Date;

public class equipment {
    private Integer equipmentid;

    private Integer userid;

    private String equipment1;

    private String equipment2;

    private String equipment3;

    private String equipment4;

    private Date time;

    public Integer getEquipmentid() {
        return equipmentid;
    }

    public void setEquipmentid(Integer equipmentid) {
        this.equipmentid = equipmentid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getEquipment1() {
        return equipment1;
    }

    public void setEquipment1(String equipment1) {
        this.equipment1 = equipment1 == null ? null : equipment1.trim();
    }

    public String getEquipment2() {
        return equipment2;
    }

    public void setEquipment2(String equipment2) {
        this.equipment2 = equipment2 == null ? null : equipment2.trim();
    }

    public String getEquipment3() {
        return equipment3;
    }

    public void setEquipment3(String equipment3) {
        this.equipment3 = equipment3 == null ? null : equipment3.trim();
    }

    public String getEquipment4() {
        return equipment4;
    }

    public void setEquipment4(String equipment4) {
        this.equipment4 = equipment4 == null ? null : equipment4.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}