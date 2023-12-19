package com.school.motor.system.service.impl;

import com.school.motor.system.entities.User;
import com.school.motor.system.mapper.UserMapper;
import com.school.motor.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper mapper;
    private final BCryptPasswordEncoder encoder;
    @Autowired
    public UserServiceImpl(UserMapper mapper, BCryptPasswordEncoder encoder) {
        this.mapper = mapper;
        this.encoder = encoder;
    }

    @Override
    public List<User> select(String table, Map<String, Object> map, String... columns) {
        return mapper.select(table, map, columns);
    }

    @Override
    public int insert(User user) {
        String password = encoder.encode(user.getUserPassword());
        user.setUserPassword(password);
        return mapper.insert(user);
    }

    @Override
    public int delete(String table, String column) {
        return mapper.delete(table,column);
    }

    @Override
    public int update(User user) {
        return mapper.update(user);
    }

    @Override
    public User login(String username) {
        return mapper.login(username);
    }
}
