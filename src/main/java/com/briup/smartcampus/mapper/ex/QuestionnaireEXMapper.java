package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Questionnaire;

import java.util.List;

public interface QuestionnaireEXMapper {
    List<Questionnaire> selectNameById(int id) throws RuntimeException;//根据id查询
    List<Questionnaire> selectNameByWord(String word)throws RuntimeException;//根据关键字查询
}
