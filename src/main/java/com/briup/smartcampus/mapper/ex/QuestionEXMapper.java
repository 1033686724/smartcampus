package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.ex.QuestionEX;

import java.util.List;

public interface QuestionEXMapper {

    List<QuestionEX> selectAll() throws RuntimeException;

    List<QuestionEX> selectByNameOrType(String word) throws RuntimeException;
}
