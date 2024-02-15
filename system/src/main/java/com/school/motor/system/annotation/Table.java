package com.school.motor.system.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Table {
    @AliasFor("value")
    String description() default "";
    @AliasFor("description")
    String value() default "";
    String name() default "";
}
