package com.school.motor.system.profile;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@RestControllerAdvice
public class GlobeException {
    @ExceptionHandler(SQLException.class)
    public void sql(SQLException e, HttpServletResponse response) throws IOException {
        create(response, e.getMessage());
        e.printStackTrace();
    }

    @ExceptionHandler(IOException.class)
    public void io(IOException e, HttpServletResponse response) throws IOException {
        create(response, e.getMessage());
        e.printStackTrace();
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public void array(ArrayIndexOutOfBoundsException e, HttpServletResponse response) throws IOException {
        create(response, e.getMessage());
        e.printStackTrace();
    }

    @ExceptionHandler(NullPointerException.class)
    public void array(NullPointerException e, HttpServletResponse response) throws IOException {
        create(response, e.getMessage());
        e.printStackTrace();
    }

    //    展示页面
    private void create(HttpServletResponse response, String error) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("""
                内容：服务器正在修复中～～</br>
                情联系下工作人员</br>
                错误类型：%s
                """.formatted(error));
        writer.flush();
    }
}
