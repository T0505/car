package com.school.motor.system.service.impl;

import com.school.motor.system.entities.Question;
import com.school.motor.system.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public List<Question> select(String table, Map<String, Object> map, String... columns) {
        return null;
    }

    @Override
    public int insert(Question question) {
        return 0;
    }

    @Override
    public int delete(String table, String column) {
        return 0;
    }

    @Override
    public int update(Question question) {
        return 0;
    }
}
