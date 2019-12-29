package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.Department;

import java.util.List;

public interface DepartmentEXMapper {

    List<Department> selectByNameOrDescription(String word);
    List<Department> selectAll();



}
