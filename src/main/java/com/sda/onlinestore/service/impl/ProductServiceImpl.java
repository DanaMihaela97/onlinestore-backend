package com.sda.onlinestore.service.impl;

import com.sda.onlinestore.convertor.ProductConvertor;
import com.sda.onlinestore.dto.ProductCreateDto;
import com.sda.onlinestore.dto.ProductInfoDto;
import com.sda.onlinestore.entity.Product;
import com.sda.onlinestore.repository.ProductRepository;
import com.sda.onlinestore.service.AuthorService;
import com.sda.onlinestore.service.CategoryService;
import com.sda.onlinestore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
//    @Override
//    public List<ProductInfoDto> searchProduct(String searchTerm) {
//        List<ProductInfoDto> result = new ArrayList<>();
//        List<Product> products = productRepository.findAll();
//        for (Product product :
//                products) {
//            if(product.getTitle().toLowerCase().contains(searchTerm.toLowerCase())){
//                result.add(ProductConvertor.convertEntityToInfoDto(product));
//            }
//        }
//        return result;
//    }
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
    public ProductInfoDto findProductById(String id) {
        Product product = productRepository.findById(Integer.parseInt(id)).orElseThrow(()
                        ->new IllegalArgumentException(String.format("Product with id %s does not exist", id)));
        ProductInfoDto productInfoDto = ProductConvertor.convertEntityToInfoDto(product);
        return productInfoDto;
    }

    @Override
    public List<ProductInfoDto> getAllProducts() {
        List<ProductInfoDto> productShortInfoDtos = new ArrayList<>();
        productRepository.findAll().forEach(product->productShortInfoDtos.add(ProductConvertor.convertEntityToInfoDto(product)));
        return productShortInfoDtos;
    }

    @Override
    public void updateProductDetails(Product product) {
        Product productDB=productRepository.findById(product.getId()).get();
        productDB.setTitle(product.getTitle());
        productDB.setDescription(product.getDescription());
        productDB.setPrice(product.getPrice());
        productDB.setProductType(product.getProductType());
        productDB.setCategory(product.getCategory());
        productDB.setAuthor(product.getAuthor());
        productRepository.save(productDB);
    }

}
