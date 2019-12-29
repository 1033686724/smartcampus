package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Course;

import java.util.List;

public interface ICourseService {
    List<Course> selectAll() throws RuntimeException;//查询所有
    void deleteById(int id) throws  RuntimeException;//根据id删除
    void  saveOrUpdate(Course course)throws RuntimeException;//修改，新增
    List<Course> searcher(String key, String word)throws RuntimeException;//搜索
    Course selectById(int id) throws RuntimeException;

}
