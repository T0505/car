package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysSubject;
import com.school.motor.system.mapper.SysSubjectMapper;
import com.school.motor.system.service.SysSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class SysSubjectServiceImpl implements SysSubjectService {
    private SysSubjectMapper subject;
    @Autowired
    public void setSubject(SysSubjectMapper subject) {
        this.subject = subject;
    }

    @Override
    public List<SysSubject> select(String table, Map<String, Object> map, String... columns) {
        return subject.select(table, map, columns);
    }

    @Override
    public int insert(SysSubject sysSubject) {
        return subject.insert(sysSubject);
    }

    @Override
    public int delete(String table, String column) {
        return subject.delete(table, column);
    }

    @Override
    public int update(SysSubject sysSubject) {
        return subject.update(sysSubject);
    }
}
