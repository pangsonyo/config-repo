package com.peng.product.enums;

import lombok.Getter;

/**
 * 商品上架状态
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
     DOWN(1,"下架");

    private Integer Code;

    private String Message;

    ProductStatusEnum(Integer code, String message) {
        Code = code;
        Message = message;
    }
}
