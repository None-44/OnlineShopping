package com.example.onlineshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlineshop.domain.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao extends BaseMapper<User> {

}
