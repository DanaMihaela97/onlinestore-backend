package com.sda.onlinestore.convertor;

import com.sda.onlinestore.dto.CategoryCreateDto;
import com.sda.onlinestore.dto.CategoryInfoDto;
import com.sda.onlinestore.entity.Category;

public class CategoryConverter {
    public static Category categoryToEntity(CategoryCreateDto categoryCreateDto){
        Category category = new Category();
        category.setName(categoryCreateDto.getName());

        return category;
    }
    public static CategoryInfoDto entityToInfo (Category category){
        CategoryInfoDto categoryInfoDto = new CategoryInfoDto();
        categoryInfoDto.setName(category.getName());
        return categoryInfoDto;
    }

}
