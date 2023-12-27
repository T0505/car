package com.school.motor.system.controller;

import com.school.motor.system.entities.SysQuestion;
import com.school.motor.system.profile.Result;
import com.school.motor.system.service.SysModelService;
import com.school.motor.system.service.SysQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private SysQuestionService question;
    private SysModelService model;
    @Autowired
    public void setModel(SysModelService model) {
        this.model = model;
    }
    @Autowired
    public void setQuestion(SysQuestionService question) {
        this.question = question;
    }
    @GetMapping("/get")
    public Result<?> get(int subjectId,String title) {

        try {
            int value = model.getByTitle(title);
            Map<String,Object> map = new HashMap<>();
            map.put("model_id",value);
            map.put("subject_id",subjectId);
            List<SysQuestion> questions = question.select("sys_question", map);
            return Result.success(questions);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Result.error("题库类型" + title + "不存在");
    }
}
