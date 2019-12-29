package com.briup.smartcampus.service.impl;

import com.briup.smartcampus.bean.Region;
import com.briup.smartcampus.bean.RegionExample;
import com.briup.smartcampus.mapper.RegionMapper;
import com.briup.smartcampus.service.IRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements IRegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Override
    public List<Region> findAll() throws RuntimeException {
        RegionExample example = new RegionExample();
        return regionMapper.selectByExample(example);


    }

    @Override
    public void deleteById(int id) throws RuntimeException {
        regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Region region) throws RuntimeException {
              if (region == null){
throw new RuntimeException("参数为空");
              }
              if (region.getId()==null){
                  regionMapper.insert(region);
              }else {
                  regionMapper.updateByPrimaryKey(region);
              }

    }

    @Override
    public Region selectById(int id) throws RuntimeException {
Region region=regionMapper.selectByPrimaryKey(id);
return region;
    }
}
