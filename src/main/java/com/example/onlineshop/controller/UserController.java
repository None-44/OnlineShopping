package com.example.onlineshop.controller;

import com.example.onlineshop.domain.User;
import com.example.onlineshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 添加用户订单接口
    @PostMapping("/submit")
    public ResponseEntity<Result<String>> submit(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok(Result.success("提交成功"));
    }

    // 查询所有用户订单接口
    @GetMapping("/orders")
    public ResponseEntity<Result<List<User>>> getAllOrders() {
        List<User> orders = userService.getUsers();

        if (!orders.isEmpty()) {
            return ResponseEntity.ok(Result.success(orders));
        } else {
            return ResponseEntity.status(401).body(Result.error("无订单"));
        }
    }


    // 订单受理接口，通过订单ID接受订单
    @PostMapping("/acceptOrder/{id}")
    public ResponseEntity<Result<String>> acceptOrder(@PathVariable("id") Long id) {
        int result = userService.acceptOrder(id);
        if (result > 0) {
            return ResponseEntity.ok(Result.success("订单已受理"));
        } else {
            return ResponseEntity.status(404).body(Result.error("订单不存在"));
        }
    }
}
