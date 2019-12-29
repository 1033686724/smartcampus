package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Region;
import com.briup.smartcampus.service.IRegionService;
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
@RequestMapping("/region")
@Api(description = "校园管理")
public class RegionController {

    @Autowired
      private IRegionService regionService;
    @GetMapping("/findAll")
    @ApiOperation(value = "查询校园信息")
    public Message findAll(){
        List<Region> regions=regionService.findAll();
        return MessageUtil.success(regions);
    }
@GetMapping("/deleteById")
@ApiOperation(value = "删除数据")
@ApiImplicitParam(name="id",value = "校园id",paramType = "query",dataType ="int" ,required = true)
   public  Message deleteById(int id){
            regionService.deleteById(id);
            return MessageUtil.success();
   }
   @GetMapping("/selectById")
   @ApiImplicitParam(name="id",value = "校园id",paramType = "query",dataType ="int" ,required = true)
   @ApiOperation(value = "根据id查询数据")
   public Message selectById(int id){
       Region region=regionService.selectById(id);
       return   MessageUtil.success(region);
   }
   @PostMapping("/update")
   @ApiOperation(value = "更新信息")
   public Message update(Region region){
regionService.saveOrUpdate(region);
return MessageUtil.success();
   }
   @PostMapping("/add")
   @ApiOperation(value = "增加信息")
   public  Message add(Region region){
        regionService.saveOrUpdate(region);
        return  MessageUtil.success();
   }
}
