package com.example.onlineshop.dao;

import com.example.onlineshop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//接口类，用于操作数据库
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByIsFrozenFalseAndIsSoldFalse();  // 查找当前正在售卖的商品
}

/*继承 JpaRepository<Product, Long>，常用的方法有：
save(Product entity)：保存或更新一个商品。
findById(Long id)：根据商品 ID 查找商品。
findAll()：查询所有商品。
deleteById(Long id)：根据商品 ID 删除商品。
existsById(Long id)：检查某个商品是否存在。

以及自定义的查询方法：
查询当前处于未冻结且未售出状态的商品 Optional<Product> findByIsFrozenFalseAndIsSoldFalse();
*/