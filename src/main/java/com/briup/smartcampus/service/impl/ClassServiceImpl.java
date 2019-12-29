package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Class;
import com.briup.smartcampus.bean.ex.ClassEX;

import com.briup.smartcampus.mapper.ClassMapper;
import com.briup.smartcampus.mapper.ClassEXMapper;
import com.briup.smartcampus.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ClassEXMapper classEXMapper;

    @Override
    public List<ClassEX> findAllClassEX()  throws RuntimeException {
        List<ClassEX> list = classEXMapper.findAll();
        return list;
    }

    @Override
    public List<ClassEX> searcher(String key, String word) throws RuntimeException {
        // key 为空    word为空 表示 下拉框和后面的输入框没有什么内容
        word = word == null ? "" : word;
        if ((key == null || "".equals(key)) && (word == null || "".equals(word))) {
            word = "%" + word + "%";
            return classEXMapper.findAll();

            // key 为空    word不为空 表示 下拉框没有选择，后面的输入框有内容
        } else if ((key == null || "".equals(key)) && !"".equals(word)) {// 前面下拉框 後面 輸入框不爲空
            //根据作者或者标题去查询
            word = "%" + word + "%";
            return classEXMapper.selectClassnameOrTeacher(word);

            // 下拉框选择了标题就根据标题查询
        } else if ("classname".equals(key)) {
            word = "%" +word+"%";
            return classEXMapper.selectClassname(word);

            // 下拉框选择了作者就根据作者查询
        } else if("teacher".equals(key)) {
            word = "%" +word+"%";
            return  classEXMapper.selectTeacher(word);
        }
            return null;
        }

    @Override
    public void saveOrUpdate(Class clas) throws RuntimeException {
        if ( clas == null){
            throw new RuntimeException();
        }
        if (clas.getId() == null){
            classMapper.insert(clas);
        }else {
            classMapper.selectByPrimaryKey(clas.getId());
        }
    }

    @Override
    public void deleteBatch(int[] ids) throws RuntimeException {
        for(int id : ids) {
            classMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        classMapper.deleteByPrimaryKey(id);
    }
}
