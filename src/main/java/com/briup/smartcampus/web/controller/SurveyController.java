package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Survey;
import com.briup.smartcampus.bean.ex.SurveyEX;
import com.briup.smartcampus.service.ISurveyService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/survey")
@Api(description = "课调管理")
public class SurveyController {
    @Autowired
    private ISurveyService iSurveyService;

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有")
    public Message findAll(){
        List<SurveyEX> list = iSurveyService.selectAll();
        return MessageUtil.success(list);
    }

    @PostMapping("/add")
    @ApiOperation(value = "增加信息")
    public Message add(Survey survey,String yesOrNo){
        iSurveyService.SaveOrUpdate(survey);
        if (yesOrNo.equals("yes")){
            return MessageUtil.success(survey.getId());
        }
        if (yesOrNo.equals("no")){
            return null;
        }

        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改信息")
    public Message update(Survey survey){
        iSurveyService.SaveOrUpdate(survey);

        return MessageUtil.success();
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除")
    public Message deleteById(int id){
        iSurveyService.delete(id);
        return MessageUtil.success();
    }

    @GetMapping("/deleteByIds")
    @ApiOperation(value = "根据id批量删除")
    public Message deleteByIds(int[] ids){
        for (int id : ids){
            iSurveyService.delete(id);
            return MessageUtil.success();
        }
        return MessageUtil.success();
    }

}
