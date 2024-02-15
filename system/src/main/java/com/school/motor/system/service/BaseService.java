package com.school.motor.system.service;

import com.school.motor.system.entities.BaseEntity;
import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> {

    List<T> select(String table, Map<String,Object> map, String ...columns);

    int insert(T t);

    int delete(String table,String column);

    int update(T t);
}
