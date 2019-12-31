package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Class;
import com.briup.smartcampus.bean.ex.ClassEX;

import java.util.List;


public interface ClassService {
    List<ClassEX> findAllClassEX() throws RuntimeException;
    List<ClassEX> searcher(String key, String word) throws RuntimeException;
    void saveOrUpdate(Class clas) throws RuntimeException;

    //void deleteBatch(int[] ids) throws RuntimeException;

    void deleteById(int id) throws RuntimeException;
}
