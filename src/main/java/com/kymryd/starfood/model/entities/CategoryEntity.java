package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "category", schema = "dbo", catalog = "DB_STARFOOD")
public class CategoryEntity {
    private int categoryId;
    private Integer categoryParent;
    private int statusId;
    private StatusEntity statusByStatusId;
    private Set<CategoryLangEntity> categoryLangsByCategoryId;
    private Set<ProductEntity> productsByCategoryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

/*    @Basic
    @Column(name = "category_parent", nullable = true)
    public Integer getCategoryParent() {
        return categoryParent;
    }

    public void setCategoryParent(Integer categoryParent) {
        this.categoryParent = categoryParent;
    }*/

    @Basic
    @Column(name = "status_id", nullable = false)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return categoryId == that.categoryId &&
                statusId == that.statusId &&
                Objects.equals(categoryParent, that.categoryParent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, categoryParent, statusId);
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
    @OneToMany(mappedBy = "categoryByCategoryId")
    public Set<CategoryLangEntity> getCategoryLangsByCategoryId() {
        return categoryLangsByCategoryId;
    }

    public void setCategoryLangsByCategoryId(Set<CategoryLangEntity> categoryLangsByCategoryId) {
        this.categoryLangsByCategoryId = categoryLangsByCategoryId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "categoryByCategoryId")
    public Set<ProductEntity> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Set<ProductEntity> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
