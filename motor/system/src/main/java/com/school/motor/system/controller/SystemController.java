package com.school.motor.system.controller;

import com.school.motor.system.entities.SysUser;
import com.school.motor.system.profile.Result;
import com.school.motor.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/system")
public class SystemController {
    private SysUserService user;
    @Autowired
    public void setUser(SysUserService user) {
        this.user = user;
    }
    @PostMapping("/register")
    public Result<?> register(@RequestBody SysUser user) {
        //new Timestamp(System.currentTimeMillis()) //时间戳
        user.setCreateTime(LocalDateTime.now());
        user.setStatus(0);
        int register = this.user.insert(user);
        return Result.check(register);
    }
    @GetMapping("/csrf") //配置token
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
