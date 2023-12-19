package com.school.motor.system.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
public class BaseEntity implements Serializable {
    protected int id;
    protected Map<String,Object> params;
    protected LocalDateTime createDate;
    protected int createBy;
}
