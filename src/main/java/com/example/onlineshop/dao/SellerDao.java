package com.example.onlineshop.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onlineshop.domain.Seller;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SellerDao extends BaseMapper<Seller> {

    @Select("select * from seller where username = #{username}")
    Seller findByUsername(String username);
}




