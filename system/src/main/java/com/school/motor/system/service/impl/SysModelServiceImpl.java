package com.school.motor.system.service.impl;

import com.school.motor.system.entities.SysModel;
import com.school.motor.system.mapper.SysModelMapper;
import com.school.motor.system.service.SysModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
@Service
public class SysModelServiceImpl implements SysModelService {

    private SysModelMapper model;
    @Autowired
    public void setModel(SysModelMapper model) {
        this.model = model;
    }

    @Override
    public List<SysModel> select(String table, Map<String, Object> map, String... columns) {
        return model.select(table, map, columns);
    }

    @Override
    public int insert(SysModel sysModel) {
        return model.insert(sysModel);
    }

    @Override
    public int delete(String table, String column) {
        return model.delete(table,column);
    }

    @Override
    public int update(SysModel sysModel) {
        return model.update(sysModel);
    }

    @Override
    public int getByTitle(String title) {
        return model.getByTitle(title);
    }
}
