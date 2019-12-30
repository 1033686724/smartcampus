package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.QuestionExample;
import com.briup.smartcampus.bean.ex.QuestionEX;
import com.briup.smartcampus.mapper.QuestionMapper;
import com.briup.smartcampus.mapper.ex.QuestionEXMapper;
import com.briup.smartcampus.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionEXMapper questionEXMapper;


    @Override
    public List<QuestionEX> selectAll() throws RuntimeException {
//        QuestionExample example = new QuestionExample();
//        return questionMapper.selectByExample(example);
        List<QuestionEX> list = questionEXMapper.selectAll();
        return list;
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        questionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Question question) throws RuntimeException {
        if (question==null){
            throw new RuntimeException("参数为空");
        }else if (question.getId()==null){
            questionMapper.insert(question);
        }else {
            questionMapper.updateByPrimaryKey(question);
        }
    }

    @Override
    public List<QuestionEX> searcher( String word) throws RuntimeException {
        word =word==null?"":word;
        if ((word==null)||"".equals(word))
            return questionEXMapper.selectAll();
        else {
            word = "%" + word + "%";
            return questionEXMapper.selectByNameOrType(word);
        }
    }

    @Override
    public Question selectById(int id) throws RuntimeException {
        Question question = questionMapper.selectByPrimaryKey(id);
        return question;
    }
}
