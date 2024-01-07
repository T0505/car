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

/**
 *  【注意】：不穿参数默认就是 *
 */

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

    /**
     * 根据条件查询题库
     * @param subjectId 科目类型 例如：科一、科二等
     * @param modelId 车型分类 例如：C1、C2
     * @return
     */
    @GetMapping("/getQuestion")
    public Result<?> get(int subjectId,String modelId) {

        try {
            int value = model.getByTitle(modelId);
            Map<String,Object> map = new HashMap<>();
            map.put("model_id",value);
            map.put("subject_id",subjectId);
            List<SysQuestion> questions = question.select("sys_question", map);
            return Result.success(questions);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return Result.error("题库类型" + modelId + "不存在");
    }
}
