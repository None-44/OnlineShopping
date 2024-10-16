package com.example.onlineshop.service;

import com.example.onlineshop.dao.UserDao;
import com.example.onlineshop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // 添加用户订单
    public int addUser(User user) {
        user.setPurchaseDate(new Date());
        user.setStatus("pending");
        return userDao.insert(user);

    }

    // 查询所有用户订单
    public List<User> getUsers() {
        List<User> users=userDao.selectList(null);
        return users;
    }

    // 订单受理（商家接受订单）
    public int acceptOrder(Long userId) {
        // 通过用户ID查询订单
        User user = userDao.selectById(userId);

        if (user != null) {
            // 更新订单状态为selected，表示订单已被接受
            user.setStatus("selected");
            return userDao.updateById(user); // 更新订单状态并保存到数据库
        }
        return 0; // 订单不存在时返回0
    }
}


