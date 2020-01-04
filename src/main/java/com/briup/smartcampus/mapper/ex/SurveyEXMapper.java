package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.*;
import com.briup.smartcampus.bean.Class;
import com.briup.smartcampus.bean.ex.SurveyEX;

import java.util.List;

public interface SurveyEXMapper {
    List<SurveyEX> findAll() throws RuntimeException;

    int average(Survey survey) throws RuntimeException;

    List<SurveyEX> selectKeDiao() throws RuntimeException;

}
