package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.dto.ProductShortInfoDto;
import com.sda.onlinestore.entity.ProductType;

import java.util.List;

public interface ProductService {

    ProductInfoDto createProduct(ProductCreateDto productCreateDto);
    void deleteProduct(Integer id);

    ProductShortInfoDto findProductByTitle(String title);

    List<ProductInfoDto> getAllProducts();




}
