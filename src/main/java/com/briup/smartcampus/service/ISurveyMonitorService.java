package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Survey;

import java.util.List;

public interface ISurveyMonitorService {
    List selectByWord(String word)throws RuntimeException;
    void openStatusById(int id) throws RuntimeException;
    void stopStatusById(int id) throws RuntimeException;
}
