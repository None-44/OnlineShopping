package com.example.onlineshop.controller;

import com.example.onlineshop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    // 更新密码接口
    @PostMapping("/changePassword/{password}")
    public ResponseEntity<Result<String>> updatePassword(@PathVariable("password") String password) {
        sellerService.updatePassword(1L, password);
        return ResponseEntity.ok(Result.success("密码更新成功"));
    }

    // 登录接口，只需要密码
    @PostMapping("/login")
    public ResponseEntity<Result<String>> login(@RequestParam("password") String password) {
        // 调用服务层的登录验证方法
        int seller = sellerService.login(password);

        if (seller == 0) {
            return ResponseEntity.ok(Result.success("登录成功"));
        } else if (seller == 1) {
            return ResponseEntity.status(401).body(Result.error("用户不存在"));
        }
        else {
            return ResponseEntity.status(401).body(Result.error("密码错误"));
        }
    }

    // 复原密码接口，将密码重置为"123456"
    @PostMapping("/resetPassword")
    public ResponseEntity<Result<String>> resetPassword() {
        sellerService.resetPassword(1L);
        return ResponseEntity.ok(Result.success("密码已复原为123456"));
    }
}



