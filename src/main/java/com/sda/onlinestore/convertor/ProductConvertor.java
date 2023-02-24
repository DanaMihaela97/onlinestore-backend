package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.dto.ProductShortInfoDto;
import com.sda.onlinestore.entity.Author;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.entity.ProductType;
import com.sda.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConvertor {
    private final CategoryService categoryService;
    @Autowired

    public ProductConvertor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

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
    public static ProductShortInfoDto convertEntityToShort(Product product){
        ProductShortInfoDto productShortInfoDto = new ProductShortInfoDto();
        productShortInfoDto.setTitle(product.getTitle());
        productShortInfoDto.setDescription(product.getDescription());
        productShortInfoDto.setPrice(product.getPrice());
        productShortInfoDto.setThumbnail(product.getThumbnail());
        productShortInfoDto.setProductType(product.getProductType().toString());

        return productShortInfoDto;

    }
}
