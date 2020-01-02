package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Survey;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISurveyReviewService {
    List search(String key) throws RuntimeException;

    List selectAllCourse() throws RuntimeException;



    List selectReviewById(int id) throws RuntimeException;


        }
