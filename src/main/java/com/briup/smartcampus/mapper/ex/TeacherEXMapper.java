package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Teacher;

import java.util.List;

public interface TeacherEXMapper {
    List<Teacher> findTeacher() throws  RuntimeException;

    List<Teacher> selectPart(String value) throws  RuntimeException;

    List<Teacher> selectName(String value) throws  RuntimeException;

    List<Teacher> selectGender(String value) throws  RuntimeException;

    List<Teacher> selectStartday(String value) throws  RuntimeException;

    List<Teacher> selectBirthday(String value) throws  RuntimeException;
}
