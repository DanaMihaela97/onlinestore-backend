package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.CategoryCreateDto;
import com.sda.onlinestore.dto.CategoryInfoDto;

import com.sda.onlinestore.entity.Category;

import java.util.List;


public interface CategoryService {
    CategoryInfoDto createCategory(CategoryCreateDto categoryCreateDto);
    Category findByName(String name);
    List<Category> findAll();


}
