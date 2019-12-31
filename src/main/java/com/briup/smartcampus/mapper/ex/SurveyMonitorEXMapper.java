package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Survey;

import java.util.List;

public interface SurveyMonitorEXMapper {
    List selectByUnknown(String word);
    List selectAll();

}
