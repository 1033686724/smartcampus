package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Teacher;

import java.util.List;

public interface ITeacherServer {
    List<Teacher> selectAllTeacher() throws RuntimeException;

    void deleteById(int id)throws RuntimeException;

    void saveOrUpdate(Teacher teacher) throws RuntimeException;

    Teacher selectById(int id) throws RuntimeException;

    List<Teacher> search(String key,String value) throws RuntimeException;

    void deleteBatch(int[] ids) throws RuntimeException;
}
