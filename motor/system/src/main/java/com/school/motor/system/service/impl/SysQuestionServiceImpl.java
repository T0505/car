package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysQuestion;
import com.school.motor.system.mapper.SysQuestionMapper;
import com.school.motor.system.service.SysQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class SysQuestionServiceImpl implements SysQuestionService {
    private SysQuestionMapper question;
    @Autowired
    public void setQuestion(SysQuestionMapper question) {
        this.question = question;
    }

    @Override
    public List<SysQuestion> select(String table, Map<String, Object> map, String... columns) {
        return question.select(table,map,columns);
    }

    @Override
    public int insert(SysQuestion sysQuestion) {
        return question.insert(sysQuestion);
    }

    @Override
    public int delete(String table, String column) {
        return question.delete(table,column);
    }

    @Override
    public int update(SysQuestion sysQuestion) {
        return question.update(sysQuestion);
    }
}
