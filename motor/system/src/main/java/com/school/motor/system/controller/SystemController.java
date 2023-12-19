package com.school.motor.system.controller;

import com.school.motor.system.entities.User;
import com.school.motor.system.profile.Result;
import com.school.motor.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;

@RestController
@RequestMapping("/system")
public class SystemController {
    private UserService user;
    @Autowired
    public void setUser(UserService user) {
        this.user = user;
    }

    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setStatus(0);
        int register = this.user.insert(user);
        return Result.check(register);
    }
    @GetMapping("/csrf") //配置token
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
