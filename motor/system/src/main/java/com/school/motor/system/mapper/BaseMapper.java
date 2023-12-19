package com.school.motor.system.mapper;

import com.school.motor.system.entities.BaseEntity;
import com.school.motor.system.profile.sql.Provider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * author T
 * @param <T> 实体类
 */
public interface BaseMapper<T extends BaseEntity> {
    @SelectProvider(type = Provider.class,method = "select")
    List<T> select(String table, Map<String,Object> map, String ...columns);

    @InsertProvider(type = Provider.class,method = "insert")
    @Options(keyProperty = "id",useGeneratedKeys=true) //新增完成返回自增id
    int insert(T t);

    @DeleteProvider(type = Provider.class,method = "delete")
    int delete(String table,String column);

    @UpdateProvider(type = Provider.class,method = "update")
    int update(T t);
}
