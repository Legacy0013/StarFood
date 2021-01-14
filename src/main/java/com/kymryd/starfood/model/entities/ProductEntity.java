package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product", schema = "dbo", catalog = "DB_STARFOOD")
public class ProductEntity {
    private int productId;
    private BigDecimal productPrice;
    private int tvaId;
    private int statusId;
    private Set<MenuEntity> menusByProductId;
    private TvaEntity tvaByTvaId;
    private StatusEntity statusByStatusId;
    private Set<ProductLangEntity> productLangsByProductId;
    private Set<RecipeEntity> recipesByProductId;
    private Set<StockEntity> stocksByProductId;

    private int categoryId;
    private int productTypeId;
    private CategoryEntity categoryByCategoryId;
    private ProductTypeEntity productTypeByProductTypeId;
    private Set<RecipeEntity> recipesByProductId_0;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "product_price", nullable = false, precision = 2)
    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "tva_id", nullable = false)
    public int getTvaId() {
        return tvaId;
    }

    public void setTvaId(int tvaId) {
        this.tvaId = tvaId;
    }

    @Basic
    @Column(name = "status_id", nullable = false)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }


    @Basic
    @Column(name = "product_type_id", nullable = false)
    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId &&
                tvaId == that.tvaId &&
                statusId == that.statusId &&
                categoryId == that.categoryId &&
                productTypeId == that.productTypeId &&
                Objects.equals(productPrice, that.productPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productPrice, tvaId, statusId, categoryId, productTypeId);
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "productByMenuMain")
    public Set<MenuEntity> getMenusByProductId() {
        return menusByProductId;
    }

    public void setMenusByProductId(Set<MenuEntity> menusByProductId) {
        this.menusByProductId = menusByProductId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tva_id", referencedColumnName = "tva_id", nullable = false, insertable = false, updatable = false)
    public TvaEntity getTvaByTvaId() {
        return tvaByTvaId;
    }

    public void setTvaByTvaId(TvaEntity tvaByTvaId) {
        this.tvaByTvaId = tvaByTvaId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false, insertable = false, updatable = false)
    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }


    @JsonManagedReference
    @OneToMany(mappedBy = "productByProductId", fetch = FetchType.EAGER)
    public Set<ProductLangEntity> getProductLangsByProductId() {
        return productLangsByProductId;
    }

    public void setProductLangsByProductId(Set<ProductLangEntity> productLangsByProductId) {
        this.productLangsByProductId = productLangsByProductId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "productByProductId")
    public Set<RecipeEntity> getRecipesByProductId() {
        return recipesByProductId;
    }

    public void setRecipesByProductId(Set<RecipeEntity> recipesByProductId) {
        this.recipesByProductId = recipesByProductId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "productByProductId")
    public Set<StockEntity> getStocksByProductId() {
        return stocksByProductId;
    }

    public void setStocksByProductId(Set<StockEntity> stocksByProductId) {
        this.stocksByProductId = stocksByProductId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false, insertable = false, updatable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_type_id", referencedColumnName = "product_type_id", nullable = false, insertable = false, updatable = false)
    public ProductTypeEntity getProductTypeByProductTypeId() {
        return productTypeByProductTypeId;
    }

    public void setProductTypeByProductTypeId(ProductTypeEntity productTypeByProductTypeId) {
        this.productTypeByProductTypeId = productTypeByProductTypeId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "productByProductIdComponent")
    public Set<RecipeEntity> getRecipesByProductId_0() {
        return recipesByProductId_0;
    }

    public void setRecipesByProductId_0(Set<RecipeEntity> recipesByProductId_0) {
        this.recipesByProductId_0 = recipesByProductId_0;
    }
}
