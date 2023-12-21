package com.school.motor.system.service.impl;

import com.school.motor.system.entities.QuestionKey;
import com.school.motor.system.service.QuestionKeyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class QuestionKeyServiceImpl implements QuestionKeyService {
    @Override
    public List<QuestionKey> select(String table, Map<String, Object> map, String... columns) {
        return null;
    }

    @Override
    public int insert(QuestionKey questionKey) {
        return 0;
    }

    @Override
    public int delete(String table, String column) {
        return 0;
    }

    @Override
    public int update(QuestionKey questionKey) {
        return 0;
    }
}
