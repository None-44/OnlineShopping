package com.example.onlineshop.controller;

import com.example.onlineshop.service.ProductService;
import com.example.onlineshop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//用于处理商品的http请求
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
0
    // 发布商品
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    // 查看历史商品
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getHistoricalProducts();
        return ResponseEntity.ok(products);
    }

    // 冻结商品
    @PutMapping("/freeze/{id}")
    public ResponseEntity<Void> freezeProduct(@PathVariable Long id) {
        productService.freezeProduct(id);
        return ResponseEntity.ok().build();
    }

    // 撤下商品
    @PutMapping("/sold/{id}")
    public ResponseEntity<Void> markProductAsSold(@PathVariable Long id) {
        productService.markProductAsSold(id);
        return ResponseEntity.ok().build();
    }

    // 重新上架商品（交易失败）
    @PutMapping("/unfreeze/{id}")
    public ResponseEntity<Void> unfreezeProduct(@PathVariable Long id) {
        productService.unfreezeProduct(id);
        return ResponseEntity.ok().build();
    }
}
