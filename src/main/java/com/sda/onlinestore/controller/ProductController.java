package com.sda.onlinestore.controller;

import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;

import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.service.AuthorService;
import com.sda.onlinestore.service.CategoryService;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/onlinestore")
public class ProductController {

    private final ProductService productService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, AuthorService authorService, CategoryService categoryService) {
        this.productService = productService;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    // CRUD
    @PostMapping("/products")
    public ResponseEntity<ProductInfoDto> createProduct(@RequestBody ProductCreateDto productCreateDto){
        productCreateDto.getAuthor_id();
        ProductInfoDto productInfoDto = productService.createProduct(productCreateDto);

        return ResponseEntity.ok(productInfoDto);
    }
    @DeleteMapping("/products/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("");
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductInfoDto> findProductById(@PathVariable String id){
        ProductInfoDto ProductInfoDtos = productService.findProductById(id);
        return ResponseEntity.ok(ProductInfoDtos);
    }
    @GetMapping("/products")
    public ResponseEntity<List<ProductInfoDto>> getAllProducts(){
        List<ProductInfoDto> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }
//    @GetMapping("/search/{searchTerm}")
//    public ResponseEntity<List<ProductInfoDto>> searchProduct(@PathVariable String searchTerm){
//        List<ProductInfoDto> products = productService.searchProduct(searchTerm);
//        return ResponseEntity.ok(products);
//    }
@PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductCreateDto productDto, @PathVariable Integer id){
        Product product = ProductConvertor.createDtoToEntity(productDto,
                authorService.findByName(productDto.getAuthor_id()),
                categoryService.findByName(productDto.getCategory_name()));
        product.setId(id);
        productService.updateProductDetails(product);
        return ResponseEntity.ok("");

}


}
