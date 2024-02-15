package com.school.motor.system.entities.quote;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Skeleton {
    private String name;
    private String modifier;
    private Class<?> type;
    private Class<?> returnType;
    public Skeleton(String name, String modifier, Class<?> type) {
        this.name = name;
        this.modifier = modifier;
        this.type = type;
    }
    public Skeleton() {
    }
    private Map<String,Class<?>> parameters;
    @Override
    public String toString() {
        return "Skeleton{" +
                "name='" + name + '\'' +
                ", modifier='" + modifier + '\'' +
                ", type=" + type +
                ", returnType=" + returnType +
                ", parameters=" + parameters +
                ", annotations=" + Arrays.toString(annotations) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    public Class<?> getReturnType() {
        if (returnType == null) {
            return void.class;
        }
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }

    public Map<String, Class<?>> getParameters() {
        if (parameters == null) {
            return new HashMap<>();
        }
        return parameters;
    }

    public void setParameters(Map<String, Class<?>> parameters) {
        this.parameters = parameters;
    }

    public Annotation[] getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotation[] annotations) {
        this.annotations = annotations;
    }

    private Annotation[] annotations;
}
