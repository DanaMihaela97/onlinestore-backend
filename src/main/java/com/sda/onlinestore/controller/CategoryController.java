package com.sda.onlinestore.controller;

import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.CategoryCreateDto;
import com.sda.onlinestore.dto.CategoryInfoDto;


import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.entity.Category;

import com.sda.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/onlinestore")
public class CategoryController {

    private final CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryInfoDto> createCategory(@RequestBody CategoryCreateDto categoryCreateDto){
        CategoryInfoDto categoryInfoDto = categoryService.createCategory(categoryCreateDto);
        return ResponseEntity.ok(categoryInfoDto);
    }
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryInfoDto>>getAllCategories(){
        List<CategoryInfoDto> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/categories/{name}/products")
    public ResponseEntity<List<ProductInfoDto>> getProductsByCateg(@PathVariable String name){
        Category category=categoryService.findByName(name);
        return ResponseEntity.ok(category.getProducts().stream().map(ProductConvertor::convertEntityToInfoDto).collect(Collectors.toList()));

    }

}
