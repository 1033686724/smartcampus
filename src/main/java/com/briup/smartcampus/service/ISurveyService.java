package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Survey;
import com.briup.smartcampus.bean.ex.SurveyEX;

import java.util.List;

public interface ISurveyService {
    List<SurveyEX> selectAll() throws RuntimeException;

    void SaveOrUpdate(Survey survey) throws RuntimeException;

    void delete(int id) throws RuntimeException;

    void deleteBatch(int[] ids) throws RuntimeException;



    int averageOptions(Survey survey) throws RuntimeException;

    List<SurveyEX> selectKeDiaoInFo() throws RuntimeException;
}
