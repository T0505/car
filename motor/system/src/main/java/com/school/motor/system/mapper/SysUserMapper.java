package com.school.motor.system.mapper;

import com.school.motor.system.entities.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserMapper extends BaseMapper<SysUser>{
    @Select("""
            SELECT
            	*
            FROM
            	sys_user
            WHERE
            	username = #{username}
            """)
    SysUser login(String username);
}
