package com.sda.onlinestore.service.impl;
import com.sda.onlinestore.convertor.CategoryConverter;
import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.CategoryCreateDto;
import com.sda.onlinestore.dto.CategoryInfoDto;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.repository.CategoryRepository;
import com.sda.onlinestore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryInfoDto createCategory(CategoryCreateDto categoryCreateDto) {
        Category category = categoryRepository.save(CategoryConverter.categoryToEntity(categoryCreateDto));
        CategoryInfoDto categoryCreateDto1 = CategoryConverter.entityToInfo(category);
        return categoryCreateDto1;
    }
    @Override
    public Category findByName(String name) {
        return categoryRepository.findById(name).get();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();

    }
}
