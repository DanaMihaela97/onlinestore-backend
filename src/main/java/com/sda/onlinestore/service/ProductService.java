package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.entity.Product;


import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductInfoDto> searchProduct(String searchTerm);
    ProductInfoDto createProduct(ProductCreateDto productCreateDto);
    void deleteProduct(Integer id);

    ProductInfoDto findProductById(String id);

    List<ProductInfoDto> getAllProducts();

    void updateProductDetails(Product product);


}
