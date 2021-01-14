package com.kymryd.starfood.dto;

import com.kymryd.starfood.model.entities.ProductEntity;

public class OrderProductDto {

    private ProductEntity product;
    private Integer quantity;

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

