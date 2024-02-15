package com.school.motor.system.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
public class BaseEntity implements Serializable {
    protected int id;
    protected Map<String,Object> params;
    protected LocalDateTime createTime;
    protected int createBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
    }
}
