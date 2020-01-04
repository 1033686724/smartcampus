package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Course;
import com.briup.smartcampus.bean.Survey;
import com.briup.smartcampus.bean.ex.SurveyEX;
import com.briup.smartcampus.mapper.SurveyMapper;
import com.briup.smartcampus.mapper.ex.SurveyEXMapper;
import com.briup.smartcampus.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements ISurveyService {
    @Autowired
    private SurveyEXMapper surveyEXMapper;
    @Autowired
    private SurveyMapper surveyMapper;

    @Override
    public List<SurveyEX> selectAll() throws RuntimeException {
        List<SurveyEX> list =
        surveyEXMapper.findAll();

        return list;
    }

    @Override
    public void SaveOrUpdate(Survey survey) throws RuntimeException {

        if (survey == null){
            throw new  RuntimeException("参数不能为空");
        }else if (survey.getId() == null){
            surveyMapper.insert(survey);

        }else {
            surveyMapper.updateByPrimaryKey(survey);
        }
    }

    @Override
    public void delete(int id) throws RuntimeException {
        surveyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatch(int[] ids) throws RuntimeException {
        for(int id : ids) {
            surveyMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int averageOptions(Survey survey ) throws RuntimeException {

        return 0;
    }

    @Override
    public List<SurveyEX> selectKeDiaoInFo() throws RuntimeException {

        List<SurveyEX> list = surveyEXMapper.selectKeDiao();
        return list;
    }
}
