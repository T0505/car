package com.school.motor.system.service;

import com.school.motor.system.entities.SysUser;
import org.apache.ibatis.annotations.Select;

public interface SysUserService extends BaseService<SysUser> {
    SysUser login(String username);
}
