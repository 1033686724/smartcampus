package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Department;

import com.briup.smartcampus.mapper.DepartmentMapper;
import com.briup.smartcampus.mapper.ex.DepartmentEXMapper;
import com.briup.smartcampus.service.IDepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
   @Autowired
    private DepartmentMapper departmentMapper;
   @Autowired
    private DepartmentEXMapper departmentEXMapper;
    @Override
    public void saveOrUpdate(Department department) throws RuntimeException{
        if (department==null){
            throw new RuntimeException("参数为空");
        }else if (department.getId()==null){
            departmentMapper.insert(department);
        }else {

            departmentMapper.updateByPrimaryKey(department);
        }

    }

    @Override
    public List<Department> search(String word) throws RuntimeException {
        word =word==null?"":word;
        if ((word==null)||"".equals(word))
            return departmentEXMapper.selectAll();
        else {
            word = "%" + word + "%";
            return departmentEXMapper.selectByNameOrDescription(word);
        }
    }

//    @Override
//    public Department selectById(int id) throws RuntimeException {
//        return departmentMapper.selectByPrimaryKey(id);
//    }

    @Override
    public void deleteById(int id) throws RuntimeException {
           departmentMapper.deleteByPrimaryKey(id);
    }

//    @Override
//    public void deleteBatch(int[] id) throws RuntimeException {
//        departmentMapper.deleteByPrimaryKey();
//    }


}
