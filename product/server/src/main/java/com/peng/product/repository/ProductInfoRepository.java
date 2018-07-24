package com.peng.product.repository;

import com.peng.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//两参数为实体类 和 主键类型
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findAllByProductIdIn(List<String> productIdList);

}
