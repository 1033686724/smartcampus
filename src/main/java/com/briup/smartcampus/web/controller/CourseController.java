package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Course;
import com.briup.smartcampus.mapper.CourseMapper;
import com.briup.smartcampus.service.ICourseService;
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
@RequestMapping("/course")
@Api(description = "课程管理")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @GetMapping("/selectAll")
    @ApiOperation(value = "查询课程信息")
    public Message selectAll(){
        List<Course> list=courseService.selectAll();
        return MessageUtil.success(list);

    }
  @GetMapping("/delete")
  @ApiOperation(value = "删除课程")
  @ApiImplicitParam(name="id",value = "课程id",paramType = "query",dataType ="int" ,required = true)
   public Message delectById(int id){
        courseService.deleteById(id);
          return MessageUtil.success();
   }
    @PostMapping("/add")
    @ApiOperation(value = "新增课程")
    public Message add(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success();
    }
    @PostMapping("/update")
    @ApiOperation(value = "更新信息")
    public Message update(Course course){
        courseService.saveOrUpdate(course);
        return MessageUtil.success();
    }

    @GetMapping("/selectByCondi")
    @ApiOperation(value = "关键词查询")
    public Message selectByCondi(String key, String word){
      List<Course> list=courseService.searcher(key,word);
      return MessageUtil.success(list);
    }
    @GetMapping("/deleteBatch")
    @ApiOperation(value = "批量删除")
    public Message deleteBatch(int[] ids){
        for (int id:ids){
            courseService.deleteById(id);
            System.out.println(id);
        }
        return MessageUtil.success();
    }
    @GetMapping("/selectById")
@ApiOperation(value ="根据id查询课程" )
    @ApiImplicitParam(name="id",value = "课程id",paramType = "query",dataType ="int" ,required = true)
    public Message selectById(int id){
        Course course=courseService.selectById(id);
        return MessageUtil.success(course);
    }
}
