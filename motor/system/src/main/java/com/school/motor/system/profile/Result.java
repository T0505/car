package com.school.motor.system.profile;

public class Result<T> {
    private final T data;
    private final String message;
    private final int code;
    public static Result<?> success(Object o) {
        return new Result<>(o,"success",200);
    }
    public static Result<?> success() {
        return new Result<>(null,"success",200);
    }
    public static Result<?> check(int count) {
        if(count == 0) {
            return error();
        }
        return success();
    }
    public static Result<?> error(Object o) {
        return new Result<>(o,"error",500);
    }
    public static Result<?> error() {
        return new Result<>(null,"error",500);
    }

    public Result(T data, String message, int code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
