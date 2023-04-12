package com.sda.onlinestore.dto;

import com.sda.onlinestore.entity.OrderList;
import com.sda.onlinestore.entity.Product;
import jakarta.persistence.*;

public class OrderLineDto {
    private Integer numberOfProducts;
    private Double productPrice;
    private Integer product_id;
    private Integer order_id;

    public Integer getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(Integer numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
}
