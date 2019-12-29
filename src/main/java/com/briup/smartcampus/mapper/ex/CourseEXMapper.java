package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Course;

import java.util.List;

public interface CourseEXMapper {
    List<Course> selectNameOrPeriodOrDescription(String word);
    List<Course> selectName(String word);
    List<Course> selectPeriod(String word);
    List<Course> selectDescription(String word);
}
