package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Class;
import com.briup.smartcampus.bean.ex.ClassEX;
import com.briup.smartcampus.service.ClassService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
@Api(description = "班级管理")
public class ClassController {
    @Autowired
    private ClassService classService;

    @GetMapping("/selectAll")
    public Message selectAll() {
        List<ClassEX> list = classService.findAllClassEX();
        return MessageUtil.success(list);
    }

    @GetMapping("/selectByCondi")
    public Message selectByCondi(String key, String word) {
        List<ClassEX> list = classService.searcher(key, word);
        return MessageUtil.success(list);
    }

    @PostMapping("/add")
    public Message save(Class clas) {
        classService.saveOrUpdate(clas);
        return MessageUtil.success();
    }


    @DeleteMapping("/deleteBatch")
    @ApiOperation(value = "批量删除")
    public Message deleteBatch(int[] ids){
        for (int id : ids){
            classService.deleteById(id);
        }
        return MessageUtil.success();
    }
    @DeleteMapping("/deleteById")
    @ApiModelProperty("按id删除")
    public Message deleteById(int id){
        classService.deleteById(id);
        return MessageUtil.success();
    }

}
