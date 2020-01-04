package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.ex.SurveyEX;
import com.briup.smartcampus.bean.ex.SurveyEX_1;

import java.util.List;

public interface IServeyCheckService {
    List selectKeDiaoInFo() throws RuntimeException;

//    List averageKeDioaInFo(SurveyEX surveyEX) throws RuntimeException;

    List selectAverage()throws RuntimeException;

 //   List findById();
}
