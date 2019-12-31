package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.*;
import com.briup.smartcampus.mapper.QqnMapper;
import com.briup.smartcampus.mapper.QuestionMapper;
import com.briup.smartcampus.mapper.QuestionnaireMapper;
import com.briup.smartcampus.mapper.SurveyMapper;
import com.briup.smartcampus.mapper.ex.QuestionnaireEXMapper;
import com.briup.smartcampus.service.IQuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class QuestionnaireServiceImpl implements IQuestionnaireService {
    @Autowired
    private QuestionnaireMapper questionnaireMapper;
    @Autowired
    private QuestionnaireEXMapper questionnaireEXMapper;
    @Autowired
    private QqnMapper qqnMapper;
    @Autowired
    private SurveyMapper surveyMapper;
    @Autowired
    private QuestionMapper questionMapper;

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
    public Questionnaire selectById(int id) throws RuntimeException {
            return questionnaireMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(int id) throws RuntimeException {

            QqnExample qqnExample=new QqnExample();
            qqnExample.createCriteria().andQuestionnaireIdEqualTo(id);
            qqnMapper.deleteByExample(qqnExample);

            qqnMapper.deleteByExample(qqnExample);
            SurveyExample surveyExample=new SurveyExample();

            surveyExample.createCriteria().andQuestionnaireIdEqualTo(id);
            surveyMapper.deleteByExample(surveyExample);

        questionnaireMapper.deleteByPrimaryKey(id);

    }



    @Override
    public <T>  preview(int id) throws RuntimeException {
        Questionnaire questionnaire=questionnaireMapper.selectByPrimaryKey(id);

        QqnExample qqnExample=new QqnExample();
        qqnExample.createCriteria().andQuestionnaireIdEqualTo(id);
        List<Qqn> list=qqnMapper.selectByExample(qqnExample);
         List<Question> list1=null;
        for (int i=0;i<list.size();i++){
            QuestionExample questionExample=new QuestionExample();
            questionExample.createCriteria().andIdEqualTo(list.get(i).getQuestionId());
            List<Question> question=questionMapper.selectByExample(questionExample);
            list1.addAll(question);

        }
        return questionnaire;
    }


}
