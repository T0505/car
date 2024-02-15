package com.school.motor.system.profile.generate;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class Service extends Base{
    public Service(SqlSessionFactory factory) {
        super(factory);
    }

    @Override
    protected void create(String table) throws IOException {

    }
}
