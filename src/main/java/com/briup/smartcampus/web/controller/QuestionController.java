package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Class;
import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.ex.ClassEX;
import com.briup.smartcampus.bean.ex.QuestionEX;
import com.briup.smartcampus.service.ClassService;
import com.briup.smartcampus.service.IQuestionService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
@Api(description = "问题")
public class QuestionController {
    @Autowired
    private IQuestionService iQuestionService;

    @GetMapping("/selectAll")
    public Message selectAll() {
        List<QuestionEX> list = iQuestionService.selectAll();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectByCondi")
    public Message selectByCondi(String word) {
        List<QuestionEX> list = iQuestionService.searcher(word);
        return MessageUtil.success(list);
    }

    @PostMapping("/add")
    public Message save(Question question) {
        iQuestionService.saveOrUpdate(question);
        return MessageUtil.success();
    }


    @GetMapping("/deleteBatch")
    @ApiOperation(value = "批量删除")
    public Message deleteBatch(int[] ids){
        for (int id : ids){
            iQuestionService.deleteById(id);
        }
        return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiModelProperty("按id删除")
    public Message deleteById(int id){
        iQuestionService.deleteById(id);
        return MessageUtil.success();
    }
}
