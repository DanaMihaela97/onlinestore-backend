package com.sda.onlinestore.service;


import com.sda.onlinestore.dto.AuthorInfoDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.entity.Author;

import java.util.List;

public interface AuthorService {

Author createAuthor(Author author);
Author findByName(String name);
List<AuthorInfoDto> findAll();
List<ProductInfoDto> findProductsByAuthor(String name) ;


}
