package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.ex.SurveyEX;
import com.briup.smartcampus.bean.ex.SurveyEX_1;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SurveyCheckEXMapper {
    List selectKeDiao() throws RuntimeException;

    List averageKeDioa(SurveyEX surveyEX) throws RuntimeException;

    List findAverage();
}
