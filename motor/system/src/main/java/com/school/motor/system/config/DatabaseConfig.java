package com.school.motor.system.config;

import com.school.motor.system.profile.generate.Base;
import com.school.motor.system.profile.generate.Entity;
import com.school.motor.system.profile.generate.Mapper;
import com.school.motor.system.profile.generate.Service;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    private final SqlSessionFactory factory;
    @Autowired
    public DatabaseConfig(SqlSessionFactory factory) {
        this.factory = factory;
    }
    @Bean("entity")
    public Base getEntity(){
        return new Entity(factory);
    }
    @Bean("mapper")
    public Base getMapper() {
        return new Mapper(factory);
    }
    @Bean("service")
    public Base getService() {
        return new Service(factory);
    }

    @Bean
    public PersistentTokenRepository getPersistentTokenRepository(DataSource source) {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
//        自动创建表语句，todo 只能使用一次哦
//        repository.setCreateTableOnStartup(true);
        repository.setDataSource(source);
        return repository;
    }
}
