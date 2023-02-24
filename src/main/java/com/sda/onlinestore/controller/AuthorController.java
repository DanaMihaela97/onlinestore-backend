package com.sda.onlinestore.controller;

import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.AuthorInfoDto;
import com.sda.onlinestore.dto.ProductShortInfoDto;
import com.sda.onlinestore.entity.Author;
import com.sda.onlinestore.entity.Category;
import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.exception.AuthorException;
import com.sda.onlinestore.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1/onlinestore")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        Author author1 = authorService.createAuthor(author);
        return ResponseEntity.ok(author1);
    }
    @GetMapping("/authors")
    public ResponseEntity<List<AuthorInfoDto>>getAllAuthors(){
        List<AuthorInfoDto> authors = authorService.findAll();
        return ResponseEntity.ok(authors);
    }
    @GetMapping("/authors/{name}/products")
    public ResponseEntity<List<ProductShortInfoDto>> getProductsByAuthor(@PathVariable String name){
        List<ProductShortInfoDto> products=authorService.findProductsByAuthor(name);
        return ResponseEntity.ok(products);

    }

}
