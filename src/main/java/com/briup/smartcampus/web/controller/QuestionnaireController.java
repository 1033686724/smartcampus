package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.service.IQuestionnaireService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/问卷管理")
@Api(description = "问卷管理")
public class QuestionnaireController {
    @Autowired
    IQuestionnaireService iQuestionnaireService;

    public Message addQuestionnaire(Questionnaire questionnaire){
        iQuestionnaireService.saveOrUpdate(questionnaire);
        return MessageUtil.success();
    }

    //搜索
    @GetMapping("/selectById")
    @ApiModelProperty(value = "按照id查询")
    public Message selectById(int id){

        return MessageUtil.success(iQuestionnaireService.selectById(id));
    }
    @GetMapping("/selectByWord")
    @ApiModelProperty(value = "按照关键字查询")
    public  Message selectByWord(String word){
        List<Questionnaire> list=iQuestionnaireService.searchByWord(word);
        return MessageUtil.success(list);
    }




}
