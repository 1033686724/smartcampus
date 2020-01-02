package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Survey;

import java.util.List;

public interface SurveyReviewEXMapper {
    List selectallByKey(String key) throws RuntimeException;

    List selectAll() throws RuntimeException;

    List selectReviewById(int id) throws RuntimeException;






}

