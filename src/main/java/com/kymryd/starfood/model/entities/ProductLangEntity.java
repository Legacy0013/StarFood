package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_lang", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(ProductLangEntityPK.class)
public class ProductLangEntity {
    private int productId;
    private int langId;
    private String productLangShortDescription;
    private String productLangLongDescription;
    private ProductEntity productByProductId;
    private LangEntity langByLangId;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "lang_id", nullable = false)
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Basic
    @Column(name = "product_lang_short_description", nullable = false, length = 255)
    public String getProductLangShortDescription() {
        return productLangShortDescription;
    }

    public void setProductLangShortDescription(String productLangShortDescription) {
        this.productLangShortDescription = productLangShortDescription;
    }

    @Basic
    @Column(name = "product_lang_long_description", nullable = false, length = -1)
    public String getProductLangLongDescription() {
        return productLangLongDescription;
    }

    public void setProductLangLongDescription(String productLangLongDescription) {
        this.productLangLongDescription = productLangLongDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLangEntity that = (ProductLangEntity) o;
        return productId == that.productId &&
                langId == that.langId &&
                Objects.equals(productLangShortDescription, that.productLangShortDescription) &&
                Objects.equals(productLangLongDescription, that.productLangLongDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, langId, productLangShortDescription, productLangLongDescription);
    }

    @JsonBackReference
//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", referencedColumnName = "lang_id", nullable = false, insertable = false, updatable = false)
    public LangEntity getLangByLangId() {
        return langByLangId;
    }

    public void setLangByLangId(LangEntity langByLangId) {
        this.langByLangId = langByLangId;
    }
}
