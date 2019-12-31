package com.briup.smartcampus.web.controller;


import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.service.IQuestionnaireService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Questionnaire")
@Api(description = "问卷管理")
public class QuestionnaireController {
    @Autowired
    IQuestionnaireService iQuestionnaireService;


    @ApiModelProperty("按id添加")
    @PostMapping("/addById")
    public Message addQuestionnaire(Questionnaire questionnaire, int[] qid){
        for (int i=0;i<qid.length;i++){
            iQuestionnaireService.saveOrUpdate(questionnaire,qid[i]);
        }
        return MessageUtil.success();
    }

    //搜索
    @GetMapping("/selectById")
    public Message selectById(int id){

        return MessageUtil.success(iQuestionnaireService.selectById(id));
    }
    @GetMapping("/selectByWord")
    public  Message selectByWord(String word){
        List<Questionnaire> list=iQuestionnaireService.searchByWord(word);
        return MessageUtil.success(list);
    }
    @GetMapping("/Preview")
    public  Message  preview(int id){
        List<Object> list=new ArrayList<>();
        list.add(iQuestionnaireService.preview(id));
        list.add(iQuestionnaireService.previewQn(id));
        return MessageUtil.success(list);
    }

    @DeleteMapping("/deleteQustionnaire")
    public Message deleteQuestionnaire(int id){
        iQuestionnaireService.deleteById(id);
        return MessageUtil.success();
    }
    @DeleteMapping("/deleteBatch")
    public Message deleteBatch(int[] id){
        for (int i=0;i<id.length;i++){
        iQuestionnaireService.deleteById(id[i]);}
        return MessageUtil.success();
    }


}
