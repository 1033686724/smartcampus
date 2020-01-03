package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Survey;
import com.briup.smartcampus.bean.SurveyExample;
import com.briup.smartcampus.mapper.SurveyMapper;
import com.briup.smartcampus.mapper.ex.SurveyReviewEXMapper;
import com.briup.smartcampus.service.ISurveyReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyReviewServiceImpl implements ISurveyReviewService {

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private SurveyReviewEXMapper surveyReviewEXMapper;


    @Override
    public List search(String key) throws RuntimeException {
        if (key == null || key.equals("")) {
            SurveyExample example = new SurveyExample();
            surveyMapper.selectByExample(example);
        } else {
            key = "%" + key + "%";
            return surveyReviewEXMapper.selectallByKey(key);
        }
        return  null;
    }

    @Override
    public List selectAllCourse() throws RuntimeException {
      return   surveyReviewEXMapper.selectAll();

    }




    @Override
    public List selectReviewById(int id) throws RuntimeException {
        return surveyReviewEXMapper.selectReviewById(id);
    }



}
