package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.SurveyExample;
import com.briup.smartcampus.bean.ex.SurveyEX;
import com.briup.smartcampus.bean.ex.SurveyEX_1;
import com.briup.smartcampus.mapper.SurveyMapper;
import com.briup.smartcampus.mapper.ex.SurveyCheckEXMapper;
import com.briup.smartcampus.mapper.ex.SurveyEXMapper;
import com.briup.smartcampus.service.IServeyCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SurveyCheckServiceImpl implements IServeyCheckService {
    @Autowired
    private SurveyCheckEXMapper surveyCheckEXMapper;
    @Autowired
    private SurveyMapper surveyMapper;

    @Override
    public List selectKeDiaoInFo() throws RuntimeException {

        List list = surveyCheckEXMapper.selectKeDiao();
        return list;
    }

    @Override
    public List selectAverage() throws RuntimeException {

        SurveyExample example = new SurveyExample();
        example.createCriteria().andCodeEqualTo(1) ;
//        example.createCriteria().andClazzIdEqualTo();
        List list = surveyMapper.selectByExample(example);
        return list;
    }

//    @Override
//    public List findById() {
//        List list = surveyCheckEXMapper.findAverage();
//        return list;
//    }



//    @Override
//    public List averageKeDioaInFo(SurveyEX surveyEX) throws RuntimeException {
//        if (surveyEX.getCode() == 1) {
//            if (surveyEX.getClazzId() == 1) {
//                List list = surveyEX.getAverage();
//                return list;
//
//
//            } else if (surveyEX.getClazzId() == 24) {
//                List list = surveyEX.getAverage();
//                return list;
//
//            } else if (surveyEX.getClazzId() == 25) {
//                List list = surveyEX.getAverage();
//                return list;
//
//
//            } else if (surveyEX.getClazzId() == 26) {
//                List list = surveyEX.getAverage();
//                return list;
//
//            }
//        }
//        return null;
//    }
}

