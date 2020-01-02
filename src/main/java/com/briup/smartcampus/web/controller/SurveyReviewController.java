package com.briup.smartcampus.web.controller;



import com.briup.smartcampus.service.ISurveyReviewService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/survyReview")
public class SurveyReviewController {
    @Autowired
    private ISurveyReviewService iSurveyReviewService;

    //搜索
    @GetMapping("/SelectAllByKey")
    public Message selectAll(String key){
        List list = iSurveyReviewService.selectAllCourse();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectReview")
    public Message selectReviewById(int id){
        List list = iSurveyReviewService.selectReviewById(id);
        return MessageUtil.success(list);
    }







}
