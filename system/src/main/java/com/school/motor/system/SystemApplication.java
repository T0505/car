package com.school.motor.system;


import com.school.motor.system.profile.generate.Base;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

import static com.school.motor.system.utils.QRCodeUtil.generate;
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
        System.out.println("( 0_0) starter...");
    }
    @Override
    public void run(String... args) throws Exception {
        entity.initialization(
                "system/src/main/java/com/school/motor/system/entities",
                "sys_user");
        entity.generate();
    }
}
