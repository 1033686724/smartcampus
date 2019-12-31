package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Qqn;
import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.bean.ex.QuestionnaireEX;
import com.briup.smartcampus.service.IQuestionnaireService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/问卷管理")
@Api(description = "问卷管理")
public class QuestionnaireController {
    @Autowired
    IQuestionnaireService iQuestionnaireService;
    @PostMapping("/addById")
    @ApiModelProperty(value = "添加问卷")
    public Message addQuestionnaire(Questionnaire questionnaire, int[] qid){
        for (int i=0;i<qid.length;i++){
            iQuestionnaireService.saveOrUpdate(questionnaire,qid[i]);
        }
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
    @GetMapping("/Preview")
    @ApiModelProperty(value = "预览")
    public  Message  preview(int id){
        Questionnaire qs=iQuestionnaireService.selectById(id);
        return MessageUtil.success();
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
