package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Qqn;
import com.briup.smartcampus.bean.Question;
import com.briup.smartcampus.bean.Questionnaire;
import com.briup.smartcampus.mapper.QqnMapper;
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
    @Autowired
    private QqnMapper qqnMapper;
    @Override
    public void saveOrUpdate(Questionnaire questionnaire,int id) throws RuntimeException {
        if (questionnaire==null)
            throw new RuntimeException("参数为空");
        else if (questionnaire.getId()==null){
           questionnaireEXMapper.insertQuestionnaire(questionnaire);

            Qqn qqn=new Qqn();
            qqn.setQuestionnaireId(questionnaireEXMapper.selectMaxId().getId());
            qqn.setQuestionId(id);

            questionnaireEXMapper.insertQuestion(qqn);

            qqnMapper.insert(qqn);
            //questionnaireEXMapper.insertQuestion(qqn);

        }
//        else
//            questionnaireMapper.updateByPrimaryKey(questionnaire);


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
