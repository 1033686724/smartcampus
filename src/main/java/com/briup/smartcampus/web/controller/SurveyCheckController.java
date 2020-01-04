package com.briup.smartcampus.web.controller;


import com.briup.smartcampus.bean.ex.SurveyEX;
import com.briup.smartcampus.bean.ex.SurveyEX_1;
import com.briup.smartcampus.service.IServeyCheckService;
import com.briup.smartcampus.service.ISurveyService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/surveyCheck")
@Api(description = "课调审核")
public class SurveyCheckController {
    @Autowired
    private ISurveyService iSurveyService;
    @Autowired
    private IServeyCheckService iServeyCheckService;

    @GetMapping("/selectCla")
    @ApiOperation(value = "查询课调班级信息")
    public Message selectCla(){
        List list = iServeyCheckService.selectKeDiaoInFo();
        return MessageUtil.success(list);
    }

    @GetMapping("/select")
    @ApiOperation(value = "班级平均分")
    public Message selectAverage(){
      List list = iServeyCheckService.selectAverage();
        return MessageUtil.success(list);
    }

//    @GetMapping("/findAverage")
//    @ApiOperation(value = "查询平均分")
//    public Message findById(){
//
//       List list = iServeyCheckService.findById();
//        return MessageUtil.success(list);
//    }
}
