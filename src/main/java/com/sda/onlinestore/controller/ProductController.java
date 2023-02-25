package com.sda.onlinestore.controller;

import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;

import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/onlinestore")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CRUD
    @PostMapping("/products")
    public ResponseEntity<ProductInfoDto> createProduct(@RequestBody ProductCreateDto productCreateDto){
        productCreateDto.getAuthor_id();
        ProductInfoDto productInfoDto = productService.createProduct(productCreateDto);

        return ResponseEntity.ok(productInfoDto);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("");
    }
    @GetMapping("/products/{title}")
    public ResponseEntity<ProductInfoDto> findProductByTitle(@PathVariable String title){
        ProductInfoDto ProductInfoDtos = productService.findProductByTitle(title);
        return ResponseEntity.ok(ProductInfoDtos);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductInfoDto>> getAllProducts(){
        List<ProductInfoDto> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

}
