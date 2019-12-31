package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Qqn;
import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.Questionnaire;

import java.util.List;

public interface IQuestionnaireService {
    void saveOrUpdate(Questionnaire questionnaire, int i) throws RuntimeException;

    List<Questionnaire> searchByWord(String word)throws  RuntimeException;
    Questionnaire selectById(int id)throws  RuntimeException;

    void deleteById(int id) throws  RuntimeException;

    public T preview<T>(int id) throws RuntimeException;
}
