package com.school.motor.system.mapper;

import com.school.motor.system.entities.SysModel;
import org.apache.ibatis.annotations.Select;

public interface SysModelMapper extends BaseMapper<SysModel>{

    @Select("""
            SELECT
            	id
            FROM
            	sys_model
            WHERE
            	title = #{title}
            """)
    int getByTitle(String title);
}
