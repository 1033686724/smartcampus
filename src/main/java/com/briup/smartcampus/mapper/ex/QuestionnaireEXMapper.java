package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.Questionnaire;

import java.util.List;

public interface QuestionnaireEXMapper {
    List<Questionnaire> selectAll() throws RuntimeException;//查询所有
    List<Questionnaire> selectNameById(int id) throws RuntimeException;//根据id查询
    List<Questionnaire> selectNameByWord(String word)throws RuntimeException;//根据关键字查询
    void insertQuestionnaire(Questionnaire questionnaire)throws RuntimeException;
    void insertQuestion(int id,int qnid)throws RuntimeException;

}
