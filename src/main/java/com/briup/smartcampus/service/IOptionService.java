package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Options;
import com.briup.smartcampus.bean.ex.OptionEX;

import javax.swing.text.html.Option;
import java.util.List;

public interface IOptionService {
    void SaveOrUpdateOption(Options options) throws RuntimeException;

    void deleteOption(int id) throws  RuntimeException;

    List<OptionEX> findAllOption() throws RuntimeException;

}
