package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Options;
import com.briup.smartcampus.bean.ex.OptionEX;
import com.briup.smartcampus.mapper.OptionsMapper;
import com.briup.smartcampus.mapper.ex.OptionEXMapper;
import com.briup.smartcampus.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionServiceImpl implements IOptionService {

    @Autowired
    private OptionsMapper optionsMapper;
    @Autowired
    private OptionEXMapper optionEXMapper;


    @Override
    public void SaveOrUpdateOption(Options options) throws RuntimeException {
        if ( options == null) {
            throw  new RuntimeException("参数为空");
        }
        if (options.getId() == null) {

            optionsMapper.insert(options);
        } else {
           optionsMapper.updateByPrimaryKey(options);
        }
    }

    @Override
    public void deleteOption(int id) throws RuntimeException {
            optionsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<OptionEX> findAllOption() throws RuntimeException {
        List<OptionEX> list =  optionEXMapper.findAll();
        return list;
    }
}
