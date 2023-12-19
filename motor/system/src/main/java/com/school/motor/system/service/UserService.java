package com.school.motor.system.service;

import com.school.motor.system.entities.User;

public interface UserService extends BaseService<User>{
    User login(String username);
}
