package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Questionnaire;

import java.util.List;

public interface IQuestionnaireService {
    void saveOrUpdate(Questionnaire questionnaire) throws RuntimeException;

    List<Questionnaire> searchByWord(String word)throws  RuntimeException;
    List<Questionnaire> selectById(int id)throws  RuntimeException;

    void deleteById(int id) throws  RuntimeException;
    List<Questionnaire> deleteBatch(int[] id) throws  RuntimeException;

}
