package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.AuthorConverter;
import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.AuthorInfoDto;
import com.sda.onlinestore.dto.ProductInfoDto;

import com.sda.onlinestore.entity.Author;

import com.sda.onlinestore.repository.AuthorRepository;
import com.sda.onlinestore.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        Author auth = authorRepository.save(author);
        return auth;
    }

    @Override
    public Author findByName(String name) {
        return authorRepository.findById(name).get();
    }

    @Override
    public List<AuthorInfoDto> findAll() {
        List<AuthorInfoDto> authorInfoDtos = new ArrayList<>();
        authorRepository.findAll().forEach(auth->authorInfoDtos.add(AuthorConverter.entityToInfo(auth)));
        return authorInfoDtos;
    }

    @Override
    public List<ProductInfoDto> findProductsByAuthor(String name) {
       Author author = authorRepository.findById(name).get();
       if (author== null || author.getProducts().isEmpty()){
           throw new IllegalArgumentException(String.format("Author with name %s doesn't have products!", name));
       } else {
           return author.getProducts().stream().map(ProductConvertor::convertEntityToInfoDto).collect(Collectors.toList());
       }

    }

}
