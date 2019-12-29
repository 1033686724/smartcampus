package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Teacher;
import com.briup.smartcampus.service.ITeacherServer;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teacher")
@Api(description = "教师管理")
public class TeacherController {
    @Autowired
    private ITeacherServer iTeacherServer;

    @GetMapping("/selectAllTeacher")
    @ApiOperation(value = "查询所有教师")
    public Message selectAllTeacher(){
        List<Teacher> list = iTeacherServer.selectAllTeacher();
        return MessageUtil.success(list);
    }

    @GetMapping("/deleteById")
    @ApiOperation(value = "根据id删除" )
    @ApiImplicitParam(name = "id",value = "教师id",paramType = "query",dataType = "int",required = true)
    public Message deleteById(int id){
        iTeacherServer.deleteById(id);
        return MessageUtil.success();
    }

    @PostMapping("/addTeacher")
    @ApiOperation(value = "增加教师信息")
    public Message addTeacher(Teacher teacher){
        iTeacherServer.saveOrUpdate(teacher);
        return MessageUtil.success();
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改教师信息")
    @ApiImplicitParam(name = "")
    public Message update(Teacher teacher) {
        iTeacherServer.saveOrUpdate(teacher);
        return MessageUtil.success();
    }

    @GetMapping("/selectById")
    @ApiOperation(value = "根据id查询教师")
    @ApiImplicitParam(name = "id",value = "教师id",paramType = "query",dataType = "int",required = true)
    public Message selectById(int id){
        Teacher teacher = iTeacherServer.selectById(id);
        return MessageUtil.success(teacher);
    }

    @GetMapping("/search")
    @ApiOperation(value = "搜索相关信息")
    public Message search(String key, String value){
        List<Teacher> list = iTeacherServer.search(key,value);
        return MessageUtil.success(list);

    }

    @GetMapping("/deleteBatch")
    @ApiOperation(value = "批量删除")
    public Message deleteBatch(int[] ids){
        for (int id : ids){
            iTeacherServer.deleteById(id);
        }
        return MessageUtil.success();
    }


}
