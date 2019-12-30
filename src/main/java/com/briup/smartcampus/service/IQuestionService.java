package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.ex.QuestionEX;

import java.util.List;

public interface IQuestionService {

    List<QuestionEX> selectAll() throws RuntimeException;
    void  saveOrUpdate(Question question)throws RuntimeException;
    List<QuestionEX> searcher(String word)throws RuntimeException;
    Question selectById(int id) throws RuntimeException;
    void deleteById(int id) throws  RuntimeException;
}
