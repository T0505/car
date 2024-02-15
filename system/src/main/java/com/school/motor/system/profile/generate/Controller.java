package com.school.motor.system.profile.generate;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class Controller extends Base {
    public Controller(SqlSessionFactory factory) {
        super(factory);
    }

    @Override
    protected void create(String table) throws IOException {

    }
}
