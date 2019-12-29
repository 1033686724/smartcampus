package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Department;
import com.briup.smartcampus.service.IDepartmentService;
import com.briup.smartcampus.service.impl.DepartmentServiceImpl;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Department")
@Api(description = "年级管理")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl DepartmentService;

    @PostMapping("/addDepartment")
    @ApiModelProperty("增加年级")
    public Message addDepartment(Department department){
        DepartmentService.saveOrUpdate(department);
        return MessageUtil.success();
    }
    @PostMapping("/updateDepartment")
    @ApiModelProperty("修改年级")
    public Message updateDepartment(Department department){
        DepartmentService.saveOrUpdate(department);
        return MessageUtil.success();
    }
    @GetMapping("/searchDepartment")
    @ApiModelProperty("查询")
    public Message searchDepartment(String word){

        List<Department> list=DepartmentService.search(word);
        return MessageUtil.success(list);
    }
//    @PostMapping("/searchByIdDepartment")
//    @ApiModelProperty("查询1")
//    public Message searchDepartment(int id){
//        Department department=DepartmentService.selectById(id);
//        return MessageUtil.success(department);
//    }

    @GetMapping("/deleteBatch")
    @ApiModelProperty("批量删除")
    @ApiImplicitParam(name = "id",value = "逗号分隔id",dataType = "int",paramType = "query")
    public Message deleteBatch(int...id){
        for (int i=0;i<id.length;i++)
            DepartmentService.deleteById(id[i]);
        return MessageUtil.success();
    }
    @GetMapping("/deleteById")
    @ApiModelProperty("按id删除")
    public Message deleteById(int id){
        DepartmentService.deleteById(id);
        return MessageUtil.success();
    }


}
