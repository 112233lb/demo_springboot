package com.lb.demo.role.mapper;

import com.lb.demo.role.entity.Demo;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("roleDemo") //同时存在两个相同的类必须给一个声明bean的名称，否则会产生冲突
public interface DemoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    Demo selectByPrimaryKey(Integer id);

    List<Demo> selectAll();

    int updateByPrimaryKey(Demo record);
}