package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.dto.ProductShortInfoDto;
import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.exception.ProductException;
import com.sda.onlinestore.repository.ProductRepository;
import com.sda.onlinestore.service.AuthorService;
import com.sda.onlinestore.service.CategoryService;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, AuthorService authorService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public ProductInfoDto createProduct(ProductCreateDto productCreateDto) {
        Product product = productRepository.save
                (ProductConvertor.createDtoToEntity(productCreateDto,
                        authorService.findByName(productCreateDto.getAuthor_id()),
                        categoryService.findByName(productCreateDto.getCategory_name())));
        ProductInfoDto productInfoDto = ProductConvertor.convertEntityToInfoDto(product);
        return productInfoDto;
    }
    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
    @Override
    public ProductShortInfoDto findProductByTitle(String title) {
        Product product = productRepository.findByTitle(title)
                .orElseThrow(()->new ProductException("Product with title " + title + " was not found!"));
        return ProductConvertor.convertEntityToShort(product);
    }

    @Override
    public List<ProductInfoDto> getAllProducts() {
        List<ProductInfoDto> productShortInfoDtos = new ArrayList<>();
        productRepository.findAll().forEach(product->productShortInfoDtos.add(ProductConvertor.convertEntityToInfoDto(product)));
        return productShortInfoDtos;
    }
    /*public List<Product> getProductsByPrice(Double price){
        //List<ProductShortInfoDto> productShortInfoDtos = new ArrayList<>();
      return productRepository.findAll().stream().filter(el->el.getPrice().equals(price)).collect(Collectors.toList()); */


}
