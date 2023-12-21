package com.school.motor.system.service.impl;

import com.school.motor.system.entities.Category;
import com.school.motor.system.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> select(String table, Map<String, Object> map, String... columns) {
        return null;
    }

    @Override
    public int insert(Category category) {
        return 0;
    }

    @Override
    public int delete(String table, String column) {
        return 0;
    }

    @Override
    public int update(Category category) {
        return 0;
    }
}
