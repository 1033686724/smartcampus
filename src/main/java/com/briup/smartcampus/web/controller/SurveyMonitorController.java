package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.service.ISurveyMonitorService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/surveyMonitor")
@Api(description = "课调监控")
public class SurveyMonitorController {
    @Autowired
    ISurveyMonitorService iSurveyMonitorService;

    @GetMapping("/findByWord")
    public Message findByWord(String word){
        List list=iSurveyMonitorService.selectByWord(word);
        return MessageUtil.success(list);
    }
    @GetMapping("/openSurvey")
    public Message openSurvy(int id){
        iSurveyMonitorService.openStatusById(id);
        return MessageUtil.success();
    }
    @GetMapping("/stopSurvey")
    public Message stopSurvy(int id){
        iSurveyMonitorService.stopStatusById(id);
        return MessageUtil.success();
    }
}
