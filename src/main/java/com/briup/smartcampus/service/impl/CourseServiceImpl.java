package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Course;
import com.briup.smartcampus.bean.CourseExample;
import com.briup.smartcampus.mapper.CourseMapper;
import com.briup.smartcampus.mapper.ex.CourseEXMapper;
import com.briup.smartcampus.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CourseServiceImpl implements ICourseService {
@Autowired
    private CourseMapper courseMapper;
@Autowired
   private CourseEXMapper courseEXMapper;
    @Override
    public List<Course> selectAll() throws RuntimeException {
        CourseExample example = new CourseExample();
        return courseMapper.selectByExample(example);
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
          courseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Course course) throws RuntimeException {
        if (course == null){
            throw new RuntimeException("参数为空");
        }if (course.getId()==null){
           courseMapper.insert(course);
        }else{
            courseMapper.updateByPrimaryKey(course);
        }
    }

    @Override
    public List<Course> searcher(String key, String word) throws RuntimeException {
        if ((key== null||"".equals(key))&&(word == null||"".equals(word))){
               return selectAll();
        }else if ((key == null||"".equals(key))&&!"".equals(word)){
             word="%"+word+"%";
             return courseEXMapper.selectNameOrPeriodOrDescription(word);
        }else if("name".equals(key)){
             word="%"+word+"%";
             return courseEXMapper.selectName(word);
        }else if ("period".equals(key)){
            word="%"+word+"%";
            return courseEXMapper.selectPeriod(word);
        }else if ("description".equals(key)){
            word="%"+word+"%";
            return courseEXMapper.selectDescription(word);
        }
        return null;
    }
}
