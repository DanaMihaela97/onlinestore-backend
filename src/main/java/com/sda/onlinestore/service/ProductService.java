package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;


import java.util.List;

public interface ProductService {

    ProductInfoDto createProduct(ProductCreateDto productCreateDto);
    void deleteProduct(Integer id);

    ProductInfoDto findProductByTitle(String title);

    List<ProductInfoDto> getAllProducts();




}
