package com.example.onlineshop.service;

import com.example.onlineshop.dao.ProductRepository;
import com.example.onlineshop.domain.Product;
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
        /*移除检查商品是否已在售的逻辑，允许直接发布商品
        Optional<Product> existingProduct = productRepository.findByIsFrozenFalseAndIsSoldFalse();
        if (existingProduct.isPresent()) {
            throw new IllegalStateException("已有商品在售，请售出后再发布新商品");
        }*/
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

    //在创建和更新商品时，检查库存是否为0，如果为0则将商品设为售出状态
    public void updateProductStock(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("商品未找到"));
        product.setStockQuantity(quantity);
        if (quantity == 0) {
            product.setSold(true);  // 自动下架商品
        }
        productRepository.save(product);
    }

    //增加浏览和搜索商品的方法
    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getProductsByCategory(String category1, String category2) {
        return productRepository.findByCategoryLevel1OrCategoryLevel2(category1, category2);
    }

}
