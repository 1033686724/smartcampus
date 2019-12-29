package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Department;
import com.briup.smartcampus.util.Message;

import java.util.List;

public interface IDepartmentService {
     void saveOrUpdate(Department department) throws RuntimeException;
     List<Department> search(String word)throws  RuntimeException;
//     Department selectById(int id) throws RuntimeException;
     void deleteById(int id) throws  RuntimeException;



}
