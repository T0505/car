package com.school.motor.system.controller;

import com.school.motor.system.profile.Result;
import com.school.motor.system.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private QuestionService question;
    @Autowired
    public void setQuestion(QuestionService question) {
        this.question = question;
    }

    @GetMapping("/get")
    public Result<?> get(String type) {

        return Result.success();
    }
}
