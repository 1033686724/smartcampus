package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Teacher;
import com.briup.smartcampus.bean.TeacherExample;
import com.briup.smartcampus.mapper.TeacherMapper;
import com.briup.smartcampus.mapper.ex.TeacherEXMapper;
import com.briup.smartcampus.service.ITeacherServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeacherImpServer implements ITeacherServer {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private TeacherEXMapper teacherEXMapper;

    @Override
    public List<Teacher> selectAllTeacher() throws RuntimeException {
        TeacherExample example = new TeacherExample();
        List<Teacher> list = teacherMapper.selectByExample(example);


        return list;
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        teacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Teacher teacher) throws RuntimeException {
        if (teacher == null){
            throw  new RuntimeException("参数为空");
        }
        if (teacher.getId() == null){
            teacherMapper.insert(teacher);
        }else {
            teacherMapper.updateByPrimaryKey(teacher);
        }
    }

    @Override
    public Teacher selectById(int id) throws RuntimeException {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        return teacher;
    }

    @Override
    public List<Teacher> search(String key, String value) throws RuntimeException {
        value = value == null ? "" : value;
        if ((value == null || "".equals(value)) && (key == null || "".equals(key))){
           return selectAllTeacher();
        }else if ((key == null || "".equals(key)) && (! "".equals(value))){
            value = "%" + value + "%";
            return teacherEXMapper.selectPart(value);
        }else if ("name".equals(key)){
            value = "%" + value + "%";
            return teacherEXMapper.selectName(value);
        }else if ("gender".equals(key)){
            value = "%" + value + "%";
            return teacherEXMapper.selectGender(value);
        }else if ("startday".equals(key)){
            value = "%" + value + "%";
            return teacherEXMapper.selectStartday(value);
        }else if ("birthday".equals(key)){
            value = "%" + value + "%";
            return teacherEXMapper.selectBirthday(value);

        }
        return null;
    }

    @Override
    public void deleteBatch(int[] ids) throws RuntimeException {
        for(int id : ids) {
            teacherMapper.deleteByPrimaryKey(id);
        }

    }


}
