package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product_type", schema = "dbo", catalog = "DB_STARFOOD")
public class ProductTypeEntity {
    private int productTypeId;
    private String productTypeShortDescription;
    private Collection<ProductEntity> productsByProductTypeId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id", nullable = false)
    public int getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(int productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Basic
    @Column(name = "product_type_short_description", nullable = false, length = 255)
    public String getProductTypeShortDescription() {
        return productTypeShortDescription;
    }

    public void setProductTypeShortDescription(String productTypeShortDescription) {
        this.productTypeShortDescription = productTypeShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTypeEntity that = (ProductTypeEntity) o;
        return productTypeId == that.productTypeId &&
                Objects.equals(productTypeShortDescription, that.productTypeShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeId, productTypeShortDescription);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "productTypeByProductTypeId")
    public Collection<ProductEntity> getProductsByProductTypeId() {
        return productsByProductTypeId;
    }

    public void setProductsByProductTypeId(Collection<ProductEntity> productsByProductTypeId) {
        this.productsByProductTypeId = productsByProductTypeId;
    }
}
