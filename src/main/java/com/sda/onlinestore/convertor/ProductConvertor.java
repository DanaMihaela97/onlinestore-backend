package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.entity.Author;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.entity.ProductType;



public class ProductConvertor {

    public static Product createDtoToEntity(ProductCreateDto productCreateDto, Author author, Category category){
        Product product = new Product();

        product.setTitle(productCreateDto.getTitle());
        product.setDescription(productCreateDto.getDescription());
        product.setCategory(category);
        product.setPrice(productCreateDto.getPrice());
        product.setThumbnail(productCreateDto.getThumbnail());
        product.setProductType(ProductType.valueOf(productCreateDto.getProductType()));
        product.setAuthor(author);

        return product;
    }
    public static ProductInfoDto convertEntityToInfoDto(Product product){
        ProductInfoDto productInfoDto = new ProductInfoDto();
        productInfoDto.setId(product.getId());
        productInfoDto.setTitle(product.getTitle());
        productInfoDto.setDescription(product.getDescription());
        productInfoDto.setCategory_name(product.getCategory().getName());
        productInfoDto.setPrice(product.getPrice());
        productInfoDto.setThumbnail(product.getThumbnail());
        productInfoDto.setAuthor_id(product.getAuthor().getName());
        productInfoDto.setProductType(product.getProductType().toString());

        return productInfoDto;
    }

}
