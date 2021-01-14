package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "recipe", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(RecipeEntityPK.class)
public class RecipeEntity {
    private int productId;
    private int recipeQuantity;
    private int productIdComponent;
    private ProductEntity productByProductId;
    private ProductEntity productByProductIdComponent;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "recipe_quantity", nullable = false)
    public int getRecipeQuantity() {
        return recipeQuantity;
    }

    public void setRecipeQuantity(int recipeQuantity) {
        this.recipeQuantity = recipeQuantity;
    }

    @Id
    @Column(name = "product_id_component", nullable = false)
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
        RecipeEntity that = (RecipeEntity) o;
        return productId == that.productId &&
                recipeQuantity == that.recipeQuantity &&
                productIdComponent == that.productIdComponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, recipeQuantity, productIdComponent);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id_component", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    public ProductEntity getProductByProductIdComponent() {
        return productByProductIdComponent;
    }

    public void setProductByProductIdComponent(ProductEntity productByProductIdComponent) {
        this.productByProductIdComponent = productByProductIdComponent;
    }
}
