package com.peng.product.Service;

import com.peng.product.common.DecreaseStockInput;
import com.peng.product.dataobject.ProductInfo;
import com.peng.product.dto.CartDTO;

import java.util.List;

public interface ProductService {


    //查询在架商品
    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
