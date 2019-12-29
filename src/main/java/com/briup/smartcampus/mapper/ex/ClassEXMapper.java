package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.ex.ClassEX;

import java.util.List;

public interface ClassEXMapper {
    List<ClassEX> findAll();

    List<ClassEX> selectTeacher(String word);

    List<ClassEX> selectClassname(String word);

    List<ClassEX> selectClassnameOrTeacher(String word);
}

