package com.example.onlineshop.service;

import com.example.onlineshop.dao.SellerDao;
import com.example.onlineshop.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerDao sellerDao;

    // 登录，只需要验证密码
    public int login(String password) {
        Seller seller = sellerDao.findByUsername("seller");

        if (seller == null ) {

            return 1;
        }

        if (!password.equals(seller.getPassword())) {

            return 2;
        }
        return 0;
    }

    // 更新密码
    public int updatePassword(Long id, String password) {
        Seller seller = sellerDao.selectById(id);
        if (seller != null) {
            seller.setPassword(password);
            return sellerDao.updateById(seller);
        }
        return 0; // 用户不存在
    }

    // 复原密码功能，重置为默认密码 "123456"
    public int resetPassword(Long id) {
        return updatePassword(id, "123456");
    }
}




