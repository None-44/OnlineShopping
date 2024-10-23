package com.example.onlineshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Lob;
import java.util.List;


@Entity
@Table//(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // 商品唯一编号

    private String name;  // 商品名称
    private String description;  // 商品描述
    private String imageUrl;  // 商品图片链接
    private Double price;  // 商品价格

    private boolean isFrozen;  // 商品是否冻结
    private boolean isSold;  // 商品是否已售出

    private String categoryLevel1;  // 一级类别
    private String categoryLevel2;  // 二级类别

    private int stockQuantity;  // 库存数量

    @ElementCollection
    private List<String> imageUrls;  // 多张图片的链接

    @Lob
    private String richDescription;  // 富媒体格式的描述
    // 构造函数
    public Product() {
    }

    public Product(String name, String description, String imageUrl, Double price) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.isFrozen = false;  // 新发布的商品默认不冻结
        this.isSold = false;    // 新发布的商品默认未售出
    }

    // Getters 和 Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isFrozen() {
        return isFrozen;
    }

    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(String categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public String getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(String categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getRichDescription() {
        return richDescription;
    }

    public void setRichDescription(String richDescription) {
        this.richDescription = richDescription;
    }
}
