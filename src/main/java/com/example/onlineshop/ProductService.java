package com.example.onlineshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//实现商品的业务逻辑
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // 发布商品（确保只有一个商品在售）
    public Product createProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findByIsFrozenFalseAndIsSoldFalse();
        if (existingProduct.isPresent()) {
            throw new IllegalStateException("已有商品在售，请售出后再发布新商品");
        }
        return productRepository.save(product);
    }

    // 查看历史商品
    public List<Product> getHistoricalProducts() {
        return productRepository.findAll();
    }

    // 冻结商品
    public void freezeProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("商品未找到"));
        product.setFrozen(true);
        productRepository.save(product);
    }

    // 撤下商品
    public void markProductAsSold(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("商品未找到"));
        product.setSold(true);
        productRepository.save(product);
    }

    // 交易失败时，重新上架商品
    public void unfreezeProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("商品未找到"));
        product.setFrozen(false);
        productRepository.save(product);
    }
}
