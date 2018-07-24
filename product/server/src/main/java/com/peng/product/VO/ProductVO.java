package com.peng.product.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ProductVO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    //这里遇到一个坑 只在list的定义上加注解 会多出一个没有转成foods的ProductInfoVOList，百度后在get方法上加注解 才解决
    @JsonProperty("foods")
    List<ProductInfoVO> ProductInfoVOList;

    @JsonProperty("foods")
    public List<ProductInfoVO> getProductInfoVOList() {
        return ProductInfoVOList;
    }

    public void setProductInfoVOList(List<ProductInfoVO> productInfoVOList) {
        ProductInfoVOList = productInfoVOList;
    }




}
