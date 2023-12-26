package com.school.motor.system.service;

import com.school.motor.system.entities.SysModel;

public interface SysModelService extends BaseService<SysModel> {
    int getByTitle(String title);
}
