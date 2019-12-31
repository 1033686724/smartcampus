package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Survey;
import com.briup.smartcampus.bean.SurveyExample;
import com.briup.smartcampus.mapper.SurveyMapper;
import com.briup.smartcampus.mapper.ex.SurveyMonitorEXMapper;
import com.briup.smartcampus.service.ISurveyMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SurveyMonitorService implements ISurveyMonitorService {
    @Autowired
    SurveyMapper surveyMapper;
    @Autowired
    SurveyMonitorEXMapper surveyMonitorEXMapper;
    @Override
    public List selectByWord(String word) throws RuntimeException {
       if (word==null||word.equals(""))
       {
//           SurveyExample example=new SurveyExample();
//           return surveyMapper.selectByExample(example);
            return  surveyMonitorEXMapper.selectAll();
       }else {
           word = "%"+word+"%";
           return surveyMonitorEXMapper.selectByUnknown(word);
       }
    }

    @Override
    public void openStatusById(int id) throws RuntimeException {
        Survey survey=surveyMapper.selectByPrimaryKey(id);
        survey.setStatus("开启");
        survey.setCode(survey.getId()*(int)Math.random()*1000+(int)Math.random()*100);
        surveyMapper.updateByPrimaryKey(survey);

    }

    @Override
    public void stopStatusById(int id) throws RuntimeException {
        Survey survey=surveyMapper.selectByPrimaryKey(id);
        survey.setStatus("未审核");
        surveyMapper.updateByPrimaryKey(survey);

    }
}
