package com.school.motor.system.mapper;

import com.school.motor.system.entities.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE username = #{username} LIMIT 1")
    User login(String username);
}

