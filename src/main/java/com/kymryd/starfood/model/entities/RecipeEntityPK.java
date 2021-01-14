package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RecipeEntityPK implements Serializable {
    private int productId;
    private int productIdComponent;

    @Column(name = "product_id", nullable = false)
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "product_id_component", nullable = false)
    @Id
    public int getProductIdComponent() {
        return productIdComponent;
    }

    public void setProductIdComponent(int productIdComponent) {
        this.productIdComponent = productIdComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeEntityPK that = (RecipeEntityPK) o;
        return productId == that.productId &&
                productIdComponent == that.productIdComponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productIdComponent);
    }
}
