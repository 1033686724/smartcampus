package com.briup.smartcampus.service;

import com.briup.smartcampus.bean.Region;

import java.util.List;

public interface IRegionService {
    List<Region> findAll() throws RuntimeException;
    void deleteById(int id) throws RuntimeException;
    void saveOrUpdate(Region region) throws  RuntimeException;
    Region selectById(int id)throws RuntimeException;
}
