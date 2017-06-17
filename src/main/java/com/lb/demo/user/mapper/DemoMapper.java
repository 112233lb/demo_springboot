package com.lb.demo.user.mapper;

import com.lb.demo.user.entity.Demo;
import java.util.List;

public interface DemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    Demo selectByPrimaryKey(Integer id);

    List<Demo> selectAll();

    int updateByPrimaryKey(Demo record);
}