package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysAnswer;
import com.school.motor.system.mapper.SysAnswerMapper;
import com.school.motor.system.service.SysAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class SysAnswerServiceImpl implements SysAnswerService {
    private SysAnswerMapper answer;
    @Autowired
    public void setAnswer(SysAnswerMapper answer) {
        this.answer = answer;
    }

    @Override
    public List<SysAnswer> select(String table, Map<String, Object> map, String... columns) {
        return answer.select(table, map, columns);
    }

    @Override
    public int insert(SysAnswer sysAnswer) {
        return answer.insert(sysAnswer);
    }

    @Override
    public int delete(String table, String column) {
        return answer.delete(table, column);
    }

    @Override
    public int update(SysAnswer sysAnswer) {
        return answer.update(sysAnswer);
    }
}
