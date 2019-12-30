package com.briup.smartcampus.mapper.ex;

import com.briup.smartcampus.bean.ex.OptionEX;

import java.util.List;

public interface OptionEXMapper  {
//    void insertOption(OptionEX optionEX) throws RuntimeException;
//
//    void updateOption(OptionEX optionEX) throws RuntimeException;
    List<OptionEX> findAll();
}
