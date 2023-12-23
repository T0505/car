package com.school.motor.system;

import com.school.motor.system.profile.generate.Base;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author T
 */
@SpringBootApplication
@MapperScan("com.school.motor.system.mapper")
public class SystemApplication implements CommandLineRunner {
    @Autowired
    private Base entity;
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
        //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
    }
    @Override
    public void run(String... args) throws Exception {

    }
}
