package com.briup.smartcampus.web.controller;

import com.briup.smartcampus.bean.Options;
import com.briup.smartcampus.bean.ex.OptionEX;
import com.briup.smartcampus.service.IOptionService;
import com.briup.smartcampus.util.Message;
import com.briup.smartcampus.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/options")
@Api(description = "选项")
public class OptionController {
    @Autowired
    private IOptionService iOptionService;

    @PostMapping("/addOptions")
    public Message addOptions(Options options){
        iOptionService.SaveOrUpdateOption(options);
        return MessageUtil.success();
    }

    @PostMapping("/updateOptions")
    public Message updateOptions(Options options){
        iOptionService.SaveOrUpdateOption(options);
        return MessageUtil.success();
    }

    @GetMapping("/findAllOption")
    public Message findAllOption(){
     List<OptionEX> list =  iOptionService.findAllOption();
     return MessageUtil.success(list);
    }

    @GetMapping("/deleteOption")
    @ApiImplicitParam(name = "id",value = "选项id",required = true,paramType = "query")
    public Message deleteOption(int id){
        iOptionService.deleteOption(id);
        return MessageUtil.success();
    }

}
