package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.mapper.QuestionnaireMapper;
import com.briup.smartcampus.mapper.ex.QuestionnaireEXMapper;
import com.briup.smartcampus.service.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QuestionnaireEXMapper questionnaireEXMapper;
    @Override
    public void saveOrUpdate(Questionnaire questionnaire) throws RuntimeException {
        if (questionnaire==null)
            throw new RuntimeException("参数为空");
       // else if (questionnaire.getId()==null)
           // questionnaireEXMapper.insert(questionnaire);
        else
            questionnaireMapper.updateByPrimaryKey(questionnaire);

    }


    @Override
    public List<Questionnaire> searchByWord(String word) throws RuntimeException {
            if (word==null||word.equals(""))
                return questionnaireEXMapper.selectAll();
            else{
                word ="%"+word+"%";
                return questionnaireEXMapper.selectNameByWord(word);
            }
    }

    @Override
    public List<Questionnaire> selectById(int id) throws RuntimeException {
            return questionnaireEXMapper.selectNameById(id);
    }

    @Override
    public void deleteById(int id) throws RuntimeException {

    }

    @Override
    public List<Questionnaire> deleteBatch(int[] id) throws RuntimeException {
        return null;
    }


}
