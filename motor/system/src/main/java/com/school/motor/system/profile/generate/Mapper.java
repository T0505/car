package com.school.motor.system.profile.generate;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

public class Mapper extends Base{
    public Mapper(SqlSessionFactory factory) {
        super(factory);
    }

    @Override
    protected void create(String table) throws IOException {

    }
}
